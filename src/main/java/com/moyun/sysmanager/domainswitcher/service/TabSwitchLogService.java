package com.moyun.sysmanager.domainswitcher.service;

import com.moyun.sysmanager.domainswitcher.entity.TabSwitchLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/** @author kuroneko */
public interface TabSwitchLogService extends IService<TabSwitchLog> {
    List<TabSwitchLog> findByAll(String domain);
}
