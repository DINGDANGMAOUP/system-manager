package com.moyun.sysmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.moyun.sysmanager.common.annotation.Log;
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

/** @author dzh */
@Slf4j
@RestController
@RequestMapping("sysWx")
@Validated
public class SysWxController extends BaseController {

  /** 使用中的域名表 */
  @Resource TabDomainInUseService tabDomainInUseService;
  /** 域名表 */
  @Resource TabDomainService tabDomainService;

  @GetMapping("list")
  @Transactional
  public VueResult findAll(
      @RequestParam(value = "serviceTypeId", defaultValue = "1") Integer serviceTypeId) {
    UsingDomain uDomain = tabDomainInUseService.findByUsing(serviceTypeId);
    uDomain.setUsing(true);
    List<UsingDomain> domains = tabDomainService.findBySpare(serviceTypeId, uDomain.getId());
    domains.forEach(usingDomain -> usingDomain.setUsing(false));
    ArrayList<UsingDomain> result = new ArrayList<>();
    result.add(uDomain);
    result.addAll(domains);
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
    tabDomainService.updateById(tabDomain);
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
    tabDomainService.updateById(tabDomain);
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("微信高可用：切换域名")
  @ResponseBody
  @PostMapping("/switch")
  @Transactional
  public VueResult bySwitch(@RequestBody UsingDomain usingDomain) {

    Integer serviceTypeId = usingDomain.getServiceTypeId();
    UsingIdDTO usingIdDto = tabDomainService.findByUsingId(serviceTypeId);
    TabDomainInUse inUse = new TabDomainInUse();
    inUse.setId(usingIdDto.getId());
    inUse.setDomainId(usingDomain.getId());
    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(1);
    tabDomainInUseService.updateById(inUse);
    tabDomainService.updateById(tabDomain);
    if (serviceTypeId.equals(RESURL)
        || serviceTypeId.equals(NEWONLINEMASTER)
        || serviceTypeId.equals(TESTURL)) {
      JSONObject request = RestTemplateUtil.getRequest(GET_RESULTS_PAGE);
      RestTemplateUtil.getPostJsonRequest(request, UPDATE_RESULTS_PAGE);
      logger.info(
          "操作时间({})--获取最新结果页域名更新成功（切换操作）",
          DateUtil.formatFullTime(LocalDateTime.now(), FULL_TIME_SPLIT_PATTERN));
    }
    if (serviceTypeId.equals(OLQM) || serviceTypeId.equals(MSTR)) {
      MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
      TabDomain domain = tabDomainService.getById(usingIdDto.getId());
      params.add("oldDomainName", domain.getDomain());
      params.add("newDomainName", usingDomain.getDomain());
      RestTemplateUtil.getPostFormRequest(params, UPDATE_MENU_PAGE);
      logger.info(
          "操作时间({})--菜单域名更新成功（切换操作）",
          DateUtil.formatFullTime(LocalDateTime.now(), FULL_TIME_SPLIT_PATTERN));
      return VueResult.of(VueEnum.SWITCH_FAIL);
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
      String link1 =
          StringUtils.replace(CREATE_SHORT_CHAIN, "{::domain::}", usingDomain.getDomain());
      String link2 =
          StringUtils.replace(
              CREATE_SHORT_CHAIN, "{::domain::}", usingDomain.getDomain().replace(OLRS, OLRSO));

      /** 备用 */
      String link3 =
          StringUtils.replace(CREATE_SHORT_CHAIN_BAK, "{::domain::}", usingDomain.getDomain());
      String link4 =
          StringUtils.replace(
              CREATE_SHORT_CHAIN_BAK, "{::domain::}", usingDomain.getDomain().replace(OLRS, OLRSO));
      String shortUrl1;
      String shortUrl2;
      if (usingDomain.getServiceTypeId() == RESURL || usingDomain.getServiceTypeId() == TESTURL) {

        shortUrl1 = RestTemplateUtil.getRequest(link1).getString("shortUrl");
        shortUrl2 = RestTemplateUtil.getRequest(link2).getString("shortUrl");

        if (StringUtils.isEmpty(shortUrl1) && StringUtils.isEmpty(shortUrl2)) {
          shortUrl1 = RestTemplateUtil.getRequest(link3).getString("shortUrl");
          shortUrl2 = RestTemplateUtil.getRequest(link4).getString("shortUrl");
        }
      } else {
        shortUrl1 = RestTemplateUtil.getRequest(link1).getString("shortUrl");

        if (StringUtils.isEmpty(shortUrl1)) {
          shortUrl1 = RestTemplateUtil.getRequest(link3).getString("shortUrl");
        }
        shortUrl2 = shortUrl1;
      }
      if (StringUtils.isEmpty(shortUrl1) && StringUtils.isEmpty(shortUrl2)) {
        return VueResult.of(VueEnum.TIMES_LIMIT);
      }
      TabDomain tabDomain = new TabDomain();
      tabDomain.setState(usingDomain.getState());
      tabDomain.setDomain(usingDomain.getDomain());
      tabDomain.setServiceTypeId(usingDomain.getServiceTypeId());
      tabDomain.setWxShortUrl(shortUrl1);
      tabDomain.setWxShortUrlTwo(shortUrl2);
      logger.info("需要生成短链的域名：{}",usingDomain.getDomain());
      logger.info("生成短链1：{}", shortUrl1);
      logger.info("生成短链2：{}", shortUrl2);
      tabDomainService.save(tabDomain);
      if (usingDomain.isUsing()) {
        UsingIdDTO usingId = tabDomainService.findByUsingId(usingDomain.getServiceTypeId());
        TabDomainInUse inUse = new TabDomainInUse();
        inUse.setId(usingId.getId());
        inUse.setDomainId(tabDomain.getId());
        tabDomainInUseService.updateById(inUse);
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
   * @param tabDomain 域名更新对象
   * @return 返回添加结果
   */
  @PostMapping
  @Transactional
  public VueResult update(@RequestBody @Valid TabDomain tabDomain) {
    tabDomainService.saveOrUpdate(tabDomain);
    return VueResult.success();
  }
}
