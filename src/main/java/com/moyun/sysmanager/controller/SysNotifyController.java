package com.moyun.sysmanager.controller;

import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainnamechecker.entity.TabManager;
import com.moyun.sysmanager.domainnamechecker.service.TabManagerService;
import com.moyun.sysmanager.domainswitcher.entity.Manager;
import com.moyun.sysmanager.domainswitcher.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("notify")
public class SysNotifyController extends BaseController {

  // 管理员
  @Resource
  TabManagerService TMService;
  @Resource
  ManagerService managerService;

  @GetMapping("manager")
  public VueResult findByManager() {
    return VueResult.success(TMService.list());
  }

  /**
   * domainnamechecker
   * 启用或停止 添加通知手机号  域名高可用
   *
   * @param tabManager
   * @return
   */
  @Log("新增或更新短信通知员")
  @PostMapping("update")
  public VueResult upDateByManager(@RequestBody TabManager tabManager) {
    TMService.saveOrUpdate(tabManager);
    return VueResult.success(tabManager.getTid());
  }


  @Log("删除短信通知员")
  @DeleteMapping("remove")
  public VueResult deleteByManager(@RequestBody TabManager tabManager) {
    TMService.removeById(tabManager);
    return VueResult.success();
  }

  /**
   * domainswitcher
   * 短信通知
   */

  @GetMapping("domainswitcher")
  public VueResult list() {
    return VueResult.success(managerService.list());
  }

  @Log("新增或更新短信通知员:公众号")
  @PostMapping("domainswitcher/update")
  public VueResult updateByManager(@RequestBody Manager Manager) {

    managerService.saveOrUpdate(Manager);
    return VueResult.success(Manager.getTid());
  }


  @Log("删除短信通知员:公众号")
  @DeleteMapping("domainswitcher/remove")
  public VueResult deleteByManagerOne(@RequestBody Manager Manager) {
    managerService.removeById(Manager);
    return VueResult.success();
  }
}
