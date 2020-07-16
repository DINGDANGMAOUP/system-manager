package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.pojo.WxModDto;
import com.moyun.sysmanager.common.pojo.WxPubDto;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.moyun.sysmanager.domainswitcher.entity.TabServiceType;
import com.moyun.sysmanager.domainswitcher.service.TabBlockedLogService;
import com.moyun.sysmanager.domainswitcher.service.TabDomainInUseService;
import com.moyun.sysmanager.domainswitcher.service.TabDomainService;
import com.moyun.sysmanager.domainswitcher.service.TabServiceTypeService;
import com.moyun.sysmanager.domainswitcher.service.TabShortUrlService;
import com.moyun.sysmanager.domainswitcher.service.TabSwitchLogService;
import com.moyun.sysmanager.restemplate.RestTemplateUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysWx")
public class SysWxController extends BaseController {
  // 被屏蔽的域名记录
  @Resource TabBlockedLogService TBLService;
  // 使用中的域名表
  @Resource TabDomainInUseService TDIService;
  // 服务类型
  @Resource TabServiceTypeService TTService;
  // 短网址表
  @Resource TabShortUrlService TSUService;
  // 域名替换记录
  @Resource TabSwitchLogService TSLService;
  // 域名表
  @Resource TabDomainService TDService;


  /**
   * 获取取名模块数据
   *
   * @return
   */
  @GetMapping
  @Transient
  public Result findAll() {
    ArrayList<Object> result = new ArrayList<>();
    // 取名
    WxModDto resUrl = WxModDto.resUrl();
    // 取名菜单
    WxModDto olqm = WxModDto.olqm();
    // 大师菜单
    WxModDto mstr = WxModDto.mstr();
    // 大师
    WxModDto newOnlineMaster = WxModDto.newOnlineMaster();
    // 测名
    WxModDto testUrl = WxModDto.testUrl();

    // 获取所有正在使用的域名
    List<TabDomainInUse> useList = TDIService.list();
    for (TabDomainInUse dsTabDomainInUse : useList) {
      // 得到使用中 的域名 id
      Integer domainId = dsTabDomainInUse.getDomainId();
      // 根据id查询域名信息
      TabDomain Domain = TDService.getById(domainId);
      // 查询所属服务类
      TabServiceType ServiceType = TTService.getById(Domain.getServiceTypeId());
      switch (ServiceType.getServiceType()) {
        case "testUrl":
          testUrl
              .getChildren()
              .add(new WxPubDto(Domain.getId(), Domain.getDomain(), Domain.getState(), true));
          break;
        case "resUrl":
          resUrl
              .getChildren()
              .add(new WxPubDto(Domain.getId(), Domain.getDomain(), Domain.getState(), true));
          break;
        case "olqm":
          olqm.getChildren()
              .add(new WxPubDto(Domain.getId(), Domain.getDomain(), Domain.getState(), true));
          break;
        case "mstr":
          mstr.getChildren()
              .add(new WxPubDto(Domain.getId(), Domain.getDomain(), Domain.getState(), true));
          break;
        case "newOnlineMaster":
          newOnlineMaster
              .getChildren()
              .add(new WxPubDto(1, Domain.getDomain(), Domain.getState(), true));
          break;
      }
    }
    /** 获取4个备用域名 */
    // 取名合并
    List<TabDomain> ru =
        TDService.list(
            Wrappers.<TabDomain>lambdaQuery()
                .select()
                .eq(TabDomain::getServiceTypeId, 1)
                .last("limit 4"));
    ru.forEach(tabDomain -> resUrl.getChildren().add(tabDomain));
    // 取名菜单合并
    List<TabDomain> oq =
        TDService.list(
            Wrappers.<TabDomain>lambdaQuery()
                .select()
                .eq(TabDomain::getServiceTypeId, 3)
                .last("limit 4"));
    oq.forEach(tabDomain -> olqm.getChildren().add(tabDomain));
    // 大师菜单合并
    List<TabDomain> mt =
        TDService.list(
            Wrappers.<TabDomain>lambdaQuery()
                .select()
                .eq(TabDomain::getServiceTypeId, 4)
                .last("limit 4"));
    mt.forEach(tabDomain -> mstr.getChildren().add(tabDomain));
    // 大师合并
    List<TabDomain> nom =
        TDService.list(
            Wrappers.<TabDomain>lambdaQuery()
                .select()
                .eq(TabDomain::getServiceTypeId, 5)
                .last("limit 4"));
    nom.forEach(tabDomain -> newOnlineMaster.getChildren().add(tabDomain));
    // 测名合并
    List<TabDomain> tu =
        TDService.list(
            Wrappers.<TabDomain>lambdaQuery()
                .select()
                .eq(TabDomain::getServiceTypeId, 6)
                .last("limit 4"));
    tu.forEach(tabDomain -> testUrl.getChildren().add(tabDomain));
    /** 合并结果集 */
    result.add(resUrl);
    result.add(olqm);
    result.add(mstr);
    result.add(newOnlineMaster);
    result.add(testUrl);

    return Result.success(result);
  }

  /**
   * 更新或添加域名，也可启用或停止
   * @param tabDomain
   * @return
   */
  @PostMapping
  public Result update(@RequestBody TabDomain tabDomain){
    TDService.saveOrUpdate(tabDomain);
  return Result.success();
  }
  /**
   * 切换正在使用的域名
   */
  @Transient
  public Result cutover(@RequestParam String oldDomain,@RequestParam String newDomain){
    //正在使用的域名
    TabDomain oldDm = TDService
        .getOne(Wrappers.<TabDomain>lambdaQuery().select().eq(TabDomain::getDomain, oldDomain));
    //备用域名
    TabDomain newDm = TDService
        .getOne(Wrappers.<TabDomain>lambdaQuery().select().eq(TabDomain::getDomain, newDomain));

    //切换
    TDIService.update(Wrappers.<TabDomainInUse>lambdaUpdate().set(TabDomainInUse::getDomainId,newDm.getId()).eq(TabDomainInUse::getDomainId,oldDm.getId()));


    return Result.success();
  }
}
