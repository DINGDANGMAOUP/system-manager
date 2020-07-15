package com.moyun.sysmanager.controller;

import com.moyun.sysmanager.common.result.Result;

import com.moyun.sysmanager.domainnamechecker.entity.TabDomainName;
import com.moyun.sysmanager.domainnamechecker.service.TabDomainNameService;
import com.moyun.sysmanager.domainnamechecker.service.TabErrorLogService;
import com.moyun.sysmanager.domainnamechecker.service.TabManagerService;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domain")
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
  @GetMapping
  public Result findAll() {
    List<TabDomainName> list = TDNService.listSort();
    return Result.success(list);
  }

  /**
   * 启用或停止域名 或添加域名
   *
   * @param TabDomainName
   * @return
   */
  @PostMapping("update")
  public Result updateByState(@RequestBody TabDomainName TabDomainName) {
    TDNService.saveOrUpdate(TabDomainName);
    return Result.success();
  }

  /**
   * 搜索域名
   *
   * @param key
   * @return
   */
  @GetMapping("search")
  public Result search(@RequestParam String key) {
    List<TabDomainName> res = TDNService.search(key);
    return Result.success(res);
  }
}
