package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.pojo.LogDto;
import com.moyun.sysmanager.common.pojo.OperatingEnum;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.domainnamechecker.entity.TabErrorLog;
import com.moyun.sysmanager.domainnamechecker.service.TabErrorLogService;
import com.moyun.sysmanager.domainswitcher.entity.TabBlockedLog;
import com.moyun.sysmanager.domainswitcher.entity.TabSwitchLog;
import com.moyun.sysmanager.domainswitcher.service.TabBlockedLogService;
import com.moyun.sysmanager.domainswitcher.service.TabSwitchLogService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class SysLogController extends BaseController {
  private static final String SUCCESS="成功";
  private static final String FAILURE="失败";


  /**
   * SysDomain
   */
  // 域名异常记录
  @Resource
  TabErrorLogService TELService;

  /**
   * SysWx
   */
  // 域名替换记录
  @Resource
  TabSwitchLogService TSLService;
  // 被屏蔽的域名记录
  @Resource
  TabBlockedLogService TBLService;


  /**
   * 切换日志
   */
  @GetMapping("switch")
  @Transient
  public Result findBySwitch(){
    ArrayList<LogDto> resLog = new ArrayList<>();
    List<TabSwitchLog> logs = TSLService.list(Wrappers.<TabSwitchLog>lambdaQuery().orderByAsc(TabSwitchLog::getSwitchTime));
    for(TabSwitchLog tabSwitchLog:logs){
      LogDto logDto = new LogDto();
      logDto.setNum(tabSwitchLog.getId());
      if (tabSwitchLog.getSwitchResult()>0){
        logDto.setOperating(tabSwitchLog.getOriginDomain()+OperatingEnum.SWITCH+tabSwitchLog.getNewDomain()+":"+SUCCESS);
      }else {
      logDto.setOperating(tabSwitchLog.getOriginDomain()+OperatingEnum.SWITCH.getOperating()+tabSwitchLog.getNewDomain()+":"+FAILURE);}
      logDto.setOperatingTime(tabSwitchLog.getSwitchTime());
      resLog.add(logDto);
    }
    return Result.success(resLog);
  }

  /**
   * 屏蔽日志
   * @return
   */
  @GetMapping("block")
  public Result findByBlock(){
    ArrayList<LogDto> resLog = new ArrayList<>();
    List<TabBlockedLog> blockedLogs = TBLService
        .list(Wrappers.<TabBlockedLog>lambdaQuery().orderByAsc(TabBlockedLog::getBlockTime));
    for(TabBlockedLog tabBlockedLog:blockedLogs){
      LogDto logDto = new LogDto();
      logDto.setNum(tabBlockedLog.getId());
      logDto.setOperating(tabBlockedLog.getDomain()+OperatingEnum.BLOCK);
      logDto.setOperatingTime(tabBlockedLog.getBlockTime());
      resLog.add(logDto);
    }
    return Result.success(resLog);
  }
  @GetMapping("error")
  public Result findByErroe(){
    ArrayList<LogDto> resLog = new ArrayList<>();
    List<TabErrorLog> errorLogs = TELService
        .list(Wrappers.<TabErrorLog>lambdaQuery().orderByAsc(TabErrorLog::getErrorTime));
    for(TabErrorLog tabErrorLog:errorLogs){
      LogDto logDto = new LogDto();
      logDto.setNum(tabErrorLog.getTid());
      logDto.setOperating(tabErrorLog.getDomainName());
      logDto.setErrorDesc(tabErrorLog.getErrorContent());
      logDto.setOperatingTime(tabErrorLog.getErrorTime());
      resLog.add(logDto);
    }
    return Result.success(resLog);
  }


}
