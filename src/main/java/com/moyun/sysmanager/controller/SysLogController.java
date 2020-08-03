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
  private static final String SUCCESS = "成功";
  private static final String FAILURE = "失败";

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
  TabNotifyLogService tabNotifyLogService;
  @Resource
  SysLogService sysLogService;

  /** 屏蔽日志 */
  @GetMapping("block")
  @Transient
  public VueResult findByBlock(String domain) {
    String trim = domain.trim();
    List<TabBlockedLog> list =null;
    if (trim != null) {
      list =
          TBLService.list(
              Wrappers.<TabBlockedLog>lambdaQuery().like(TabBlockedLog::getDomain, trim).orderByDesc(TabBlockedLog::getBlockTime));
    } else {

      list = TBLService.list(Wrappers.<TabBlockedLog>lambdaQuery().orderByDesc(TabBlockedLog::getBlockTime));
    }

    return VueResult.success(list);
  }
  @GetMapping("err")
  @Transient
  public VueResult findByErr(String domain) {
    String trim = domain.trim();
    List<TabErrorLog> list =null;
    if (trim!=null){
      list=tabErrorLogService.list(Wrappers.<TabErrorLog>lambdaQuery().like(TabErrorLog::getDomainName,domain).orderByDesc(TabErrorLog::getErrorTime));
    }else {

      list = tabErrorLogService.list(Wrappers.<TabErrorLog>lambdaQuery().orderByDesc(TabErrorLog::getErrorTime));
    }

    return VueResult.success(list);
  }
  @GetMapping("switch")
  @Transient
  public VueResult findBySwitch(String oldDomain,String newDomain) {
    List<TabSwitchLog> list = TSLService.list();

    return VueResult.success(list);
  }
  @GetMapping("notify")
  @Transient
  public VueResult findByNotify() {
    List<NotifyAndManagerDto> list = TNLService.findByNotifyAndManager();

    return VueResult.success(list);
  }

  @GetMapping("operationLog")
  @Transient
  public VueResult findBySysLog() {
    List<SysLog> list = sysLogService.list(Wrappers.<SysLog>lambdaQuery().orderByDesc(SysLog::getCreateTime));

    return VueResult.success(list);
  }

}
