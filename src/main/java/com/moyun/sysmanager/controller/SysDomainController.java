package com.moyun.sysmanager.controller;

import ch.qos.logback.classic.Logger;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.result.Result;

import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainnamechecker.entity.TabDomainName;
import com.moyun.sysmanager.domainnamechecker.service.TabDomainNameService;
import com.moyun.sysmanager.domainnamechecker.service.TabErrorLogService;
import com.moyun.sysmanager.domainnamechecker.service.TabManagerService;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import groovy.util.logging.Slf4j;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("SysDomain")
public class SysDomainController extends BaseController {
  // 域名
  @Resource TabDomainNameService TDNService;
  // 域名异常记录
  @Resource TabErrorLogService TELService;
  // 管理员
  @Resource TabNotifyLogService TNLService;
  // 异常通知
  @Resource TabManagerService TMService;

  /**
   * 获取域名高可用列表
   *
   * @return
   */
  @GetMapping("list")
  public VueResult findAll( String domainName) {
    String trim = domainName.trim();
    List<TabDomainName> list = null;
    if (trim != null) {
      list =
          TDNService.list(
              Wrappers.<TabDomainName>lambdaQuery().like(TabDomainName::getDomainName, trim));

    } else {
      list = TDNService.list();
    }
    return VueResult.success(list);
  }



  @Log("域名高可用：删除域名")
  @DeleteMapping("remove")
  public VueResult deleteDomain(@RequestBody @Valid TabDomainName TabDomainName) {
    TDNService.removeById(TabDomainName);
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("域名高可用：启用域名")
  @ResponseBody
  @PostMapping("/enable")
  public VueResult enable(@RequestBody  TabDomainName tabDomainName) {
    tabDomainName.setState(1);
    TDNService.updateById(tabDomainName);
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("域名高可用：停止域名")
  @ResponseBody
  @PostMapping("/disable")
  public VueResult disable(@RequestBody  TabDomainName tabDomainName) {
    tabDomainName.setState(0);
    TDNService.updateById(tabDomainName);
    return VueResult.success();
  }

  @Log("域名高可用：添加域名")
  @RequiresAuthentication
  @ResponseBody
  @PostMapping("/add")
  public VueResult add(@RequestBody @Valid TabDomainName tabDomainName) {

    TDNService.save(tabDomainName);
    return VueResult.success();
  }
}
