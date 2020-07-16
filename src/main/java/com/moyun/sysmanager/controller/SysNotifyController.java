package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.pojo.NotifyDto;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.domainnamechecker.entity.TabManager;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.moyun.sysmanager.domainnamechecker.service.TabManagerService;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notify")
public class SysNotifyController {
  // 异常通知
  @Resource TabNotifyLogService TNLService;
  // 管理员
  @Resource TabManagerService TMService;
  //  public Result notifyByDomain(){
  //    ArrayList<Object> notifyList = new ArrayList<>();
  //    List<TabNotifyLog> notifyLogs = TNLService
  //        .list(Wrappers.<TabNotifyLog>lambdaQuery().orderByAsc(TabNotifyLog::getNotifyTime));
  //    for (TabNotifyLog tabNotifyLog:notifyLogs){
  //      NotifyDto notifyDto = new NotifyDto();
  //      TabManager manager = TMService.getById(tabNotifyLog.getManagerId());
  //      notifyDto.setNum(tabNotifyLog.getTid());
  //      notifyDto.setManager(manager.getName());
  //      notifyDto.setPhone(tabNotifyLog.getTid());
  //      notifyDto.setNum(tabNotifyLog.getTid());
  //    }
  //  }

  @GetMapping("notify")
  public Result findByNotify() {
    return Result.success(TNLService.list());
  }
  @GetMapping("manager")
  public Result findByManager() {
    return Result.success(TMService.list());
  }

  /**
   * 启用或停止 添加通知手机号  域名高可用
   * @param tabManager
   * @return
   */
  @PostMapping("update")
  public Result upDateByManager(@RequestBody TabManager tabManager) {
    TMService.saveOrUpdate(tabManager);
    return Result.success();
  }
}
