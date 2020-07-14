package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.domainnamechecker.entity.DNCTabDomainName;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabDomainNameService;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabErrorLogService;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabManagerService;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabNotifyLogService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domain")
public class SysWxController {
  //域名
  @Resource
  DNCTabDomainNameService TDNService;
  //域名异常记录
  @Resource
  DNCTabErrorLogService TELService;
  //管理员
  @Resource
  DNCTabNotifyLogService TNLService;
  //异常通知
  @Resource
  DNCTabManagerService TMService;


  /**
   * 获取域名高可用列表
   * @return
   */
  @GetMapping
  public Result findAll(){
    List<DNCTabDomainName> list=TDNService.listSort();
    return Result.success(list);
  }

  /**
   * 启用或停止域名 或添加域名
   * @param dncTabDomainName
   * @return
   */
  @PostMapping("update")
  public Result updateByState(@RequestBody DNCTabDomainName dncTabDomainName){
    TDNService.saveOrUpdate(dncTabDomainName);
    return Result.success();
  }
  @GetMapping
  public Result search(@RequestParam String domainName){
   List<DNCTabDomainName> res= TDNService.search(domainName);
   return Result.success(res);
  }



}
