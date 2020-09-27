package com.moyun.sysmanager.domainnamechecker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyun.sysmanager.common.pojo.NotifyAndManagerDTO;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;

import java.util.List;

/** @author kuroneko */
public interface TabNotifyLogService extends IService<TabNotifyLog> {

    List<NotifyAndManagerDTO> findByNotifyAndManager(String domainName);
}
