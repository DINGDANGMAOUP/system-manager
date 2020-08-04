package com.moyun.sysmanager.domainnamechecker.service;

import com.moyun.sysmanager.common.pojo.NotifyAndManagerDto;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/** @author kuroneko */
public interface TabNotifyLogService extends IService<TabNotifyLog> {

  List<NotifyAndManagerDto> findByNotifyAndManager(String domainName);
}
