package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.pojo.NotifyDto;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainnamechecker.entity.TabManager;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.moyun.sysmanager.domainnamechecker.service.TabManagerService;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("notify")
public class SysNotifyController {

  // 管理员
  @Resource TabManagerService TMService;
  @GetMapping("manager")
  public VueResult findByManager() {
    return VueResult.success(TMService.list());
  }

  /**
   * 启用或停止 添加通知手机号  域名高可用
   * @param tabManager
   * @return
   */
  @Log("新增或更新管理员")
  @PostMapping("update")
  public VueResult upDateByManager(@RequestBody TabManager tabManager) {
    TMService.saveOrUpdate(tabManager);
    return VueResult.success(tabManager.getTid());
  }


  @Log("删除管理员")
  @DeleteMapping("remove")
  public VueResult deleteByManager(@RequestBody TabManager tabManager) {
    TMService.removeById(tabManager);
    return VueResult.success();
  }
}
