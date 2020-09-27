package com.moyun.sysmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.pojo.DomainUsDTO;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDTO;
import com.moyun.sysmanager.common.result.VueEnum;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.moyun.sysmanager.domainswitcher.service.TabDomainInUseService;
import com.moyun.sysmanager.domainswitcher.service.TabDomainService;
import com.moyun.sysmanager.exception.CustmerException;
import com.moyun.sysmanager.utils.DateUtil;
import com.moyun.sysmanager.utils.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.moyun.sysmanager.Constants.*;
import static com.moyun.sysmanager.utils.DateUtil.FULL_TIME_SPLIT_PATTERN;

/**
 * @author dzh
 */
@Slf4j
@RestController
@RequestMapping("sysWx")
@Validated
public class SysWxController extends BaseController {

  //  private static final String WXURLUP = "http://mytest.my9v.top/wechatrobot/wx/domain/update";
  //  private static final String WXURLUP = "http://mdk.ufuns.cn/wxserver/wx/domain/update";
  //  private static final String WXURLUP =
  // "http://wechatrobot.quming.online/wxserver/wx/domain/update";
  //  private static final String WXURLUPBAK = "http://my9f.top/shortLink/updateDomainName";
  //  private static final String WXURLUPBAK = "http://mdk.ufuns.cn/shortLink/updateDomainName";
  //  private static final String WXURLUPBAK = "http://my9f.top/shortLink/updateDomainName";

  /** 使用中的域名表 */
  @Resource
  TabDomainInUseService TDIService;
  /** 域名表 */
  @Resource
  TabDomainService TDService;

  @GetMapping("list")
  @Transactional
  public VueResult findAll(
          @RequestParam(value = "serviceTypeId", defaultValue = "1") Integer serviceTypeId) {
    UsingDomain uDomain = TDIService.findByUsing(serviceTypeId);
    uDomain.setUsing(true);
    List<UsingDomain> Domains = TDService.findBySpare(serviceTypeId, uDomain.getId());
    Domains.forEach(usingDomain -> usingDomain.setUsing(false));
    ArrayList<UsingDomain> result = new ArrayList<>();
    result.add(uDomain);
    result.addAll(Domains);
    return VueResult.success(result);
  }

  @RequiresAuthentication
  @Log("微信高可用：启用域名")
  @ResponseBody
  @PostMapping("/enable")
  @Transactional
  public VueResult enable(@RequestBody UsingDomain usingDomain) {

    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(1);
    TDService.updateById(tabDomain);
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("微信高可用：停止域名")
  @ResponseBody
  @PostMapping("/disable")
  @Transactional
  public VueResult disable(@RequestBody UsingDomain usingDomain) {
    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(0);
    TDService.updateById(tabDomain);
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("微信高可用：切换域名")
  @ResponseBody
  @PostMapping("/switch")
  @Transactional
  public VueResult bySwitch(@RequestBody UsingDomain usingDomain) {

    Integer serviceTypeId = usingDomain.getServiceTypeId();
    UsingIdDTO usingIdDto = TDService.findByUsingId(serviceTypeId);
    TabDomainInUse inUse = new TabDomainInUse();
    inUse.setId(usingIdDto.getId());
    inUse.setDomainId(usingDomain.getId());
    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(1);
    TDIService.updateById(inUse);
    TDService.updateById(tabDomain);
    if (serviceTypeId == 1 || serviceTypeId == 5 || serviceTypeId == 6) {
      JSONObject request = RestTemplateUtil.getRequest(GET_RESULTS_PAGE);
      RestTemplateUtil.getPostJsonRequest(request, UPDATE_RESULTS_PAGE);
      logger.info(
              "操作时间({})--获取最新结果页域名更新成功（切换操作）",
              DateUtil.formatFullTime(LocalDateTime.now(), FULL_TIME_SPLIT_PATTERN));
    }
    if (serviceTypeId == 3 || serviceTypeId == 4) {
      MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
      DomainUsDTO domainUsDto = TDIService.findUsingAtDomain(usingDomain.getServiceTypeId());
      params.add("oldDomainName", domainUsDto.getDomain());
      params.add("newDomainName", usingDomain.getDomain());
      RestTemplateUtil.getPostFormRequest(params, UPDATE_MENU_PAGE);
      logger.info(
              "操作时间({})--菜单域名更新成功（切换操作）",
              DateUtil.formatFullTime(LocalDateTime.now(), FULL_TIME_SPLIT_PATTERN));
    }
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("微信高可用：新增域名")
  @PostMapping("/create")
  @ResponseBody
  @Transactional
  public VueResult createTab(@RequestBody @Valid UsingDomain usingDomain) throws CustmerException {
    try {

      /** 常用 */
      String link_1 =
              StringUtils.replace(CREATE_SHORT_CHAIN, "{::domain::}", usingDomain.getDomain());
      String link_2 =
              StringUtils.replace(
                      CREATE_SHORT_CHAIN, "{::domain::}", usingDomain.getDomain().replace("olrs", "olrso"));

      /** 备用 */
      String link_3 =
              StringUtils.replace(CREATE_SHORT_CHAIN_BAK, "{::domain::}", usingDomain.getDomain());
      String link_4 =
              StringUtils.replace(
                      CREATE_SHORT_CHAIN_BAK,
                      "{::domain::}",
                      usingDomain.getDomain().replace("olrs", "olrso"));
      String shortUrl_1 = null;
      String shortUrl_2 = null;
      if (usingDomain.getServiceTypeId() == 1 || usingDomain.getServiceTypeId() == 6) {

        shortUrl_1 = RestTemplateUtil.getRequest(link_1).getString("shortUrl");
        shortUrl_2 = RestTemplateUtil.getRequest(link_2).getString("shortUrl");

        if (StringUtils.isEmpty(shortUrl_1) && StringUtils.isEmpty(shortUrl_2)) {
          shortUrl_1 = RestTemplateUtil.getRequest(link_3).getString("shortUrl");
          shortUrl_2 = RestTemplateUtil.getRequest(link_4).getString("shortUrl");
        }
      } else {
        shortUrl_1 = RestTemplateUtil.getRequest(link_1).getString("shortUrl");

        if (StringUtils.isEmpty(shortUrl_1)) {
          shortUrl_1 = RestTemplateUtil.getRequest(link_3).getString("shortUrl");
        }
        shortUrl_2 = shortUrl_1;
      }
      if (StringUtils.isEmpty(shortUrl_1) && StringUtils.isEmpty(shortUrl_2)) {
        return VueResult.of(VueEnum.TIMES_LIMIT);
      }
      TabDomain tabDomain = new TabDomain();
      tabDomain.setState(usingDomain.getState());
      tabDomain.setDomain(usingDomain.getDomain());
      tabDomain.setServiceTypeId(usingDomain.getServiceTypeId());
      tabDomain.setWxShortUrl(shortUrl_1);
      tabDomain.setWxShortUrlTwo(shortUrl_2);
      logger.info("生成短链1：{}", shortUrl_1);
      logger.info("生成短链2：{}", shortUrl_2);
      TDService.save(tabDomain);
      if (usingDomain.isUsing()) {
        UsingIdDTO usingId = TDService.findByUsingId(usingDomain.getServiceTypeId());
        TabDomainInUse inUse = new TabDomainInUse();
        inUse.setId(usingId.getId());
        inUse.setDomainId(tabDomain.getId());
        TDIService.updateById(inUse);
      }
    } catch (Exception e) {
      logger.error("{}: 参数异常", usingDomain.toString());
      throw new CustmerException(e.getMessage());
    }
    return VueResult.success();
  }

  /**
   * 更新或添加域名，也可启用或停止
   *
   * @param tabDomain
   * @return
   */
  @PostMapping
  @Transactional
  public VueResult update(@RequestBody @Valid TabDomain tabDomain) {
    TDService.saveOrUpdate(tabDomain);
    return VueResult.success();
  }
}
