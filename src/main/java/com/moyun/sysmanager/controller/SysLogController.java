package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.annotation.entity.SysLog;
import com.moyun.sysmanager.common.annotation.service.SysLogService;
import com.moyun.sysmanager.common.pojo.LogDto;
import com.moyun.sysmanager.common.pojo.NotifyAndManagerDto;
import com.moyun.sysmanager.common.pojo.OperatingEnum;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainnamechecker.entity.TabErrorLog;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.moyun.sysmanager.domainnamechecker.service.TabErrorLogService;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import com.moyun.sysmanager.domainswitcher.entity.TabBlockedLog;
import com.moyun.sysmanager.domainswitcher.entity.TabSwitchLog;
import com.moyun.sysmanager.domainswitcher.service.TabBlockedLogService;
import com.moyun.sysmanager.domainswitcher.service.TabSwitchLogService;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("SysLog")
public class SysLogController extends BaseController {

  /** SysDomain */

  // 异常通知
  @Resource TabNotifyLogService TNLService;
  @Resource
  TabErrorLogService tabErrorLogService;
  /** SysWx */
  // 域名替换记录
  @Resource TabSwitchLogService TSLService;
  // 被屏蔽的域名记录
  @Resource TabBlockedLogService TBLService;
  @Resource
  SysLogService sysLogService;

  /** 屏蔽日志 */
  @GetMapping("block")
  @Transient
  public VueResult findByBlock(String domain) {
    String trim = domain.trim();
    List<TabBlockedLog> list =
        TBLService.list(
            Wrappers.<TabBlockedLog>lambdaQuery().like(TabBlockedLog::getDomain, trim).orderByDesc(TabBlockedLog::getBlockTime));

    return VueResult.success(list);
  }
  @GetMapping("err")
  @Transient
  public VueResult findByErr(String domainName) {
    String trim = domainName.trim();
    List<TabErrorLog> list=tabErrorLogService.list(Wrappers.<TabErrorLog>lambdaQuery().like(TabErrorLog::getDomainName,trim).orderByDesc(TabErrorLog::getErrorTime));

    return VueResult.success(list);
  }
  @GetMapping("switch")
  @Transient
  public VueResult findBySwitch(String domain) {
    List<TabSwitchLog> list = TSLService.findByAll(domain);

    return VueResult.success(list);
  }
  @GetMapping("notify")
  @Transient
  public VueResult findByNotify(String domainName) {
    String trim = domainName.trim();
    List<NotifyAndManagerDto> list = TNLService.findByNotifyAndManager(trim);

    return VueResult.success(list);
  }

  @GetMapping("operationLog")
  @Transient
  public VueResult findBySysLog(String username) {
    String trim = username.trim();
    List<SysLog> list=sysLogService.list(Wrappers.<SysLog>lambdaQuery().like(SysLog::getUsername,trim).orderByDesc(SysLog::getCreateTime));


    return VueResult.success(list);
  }

}
