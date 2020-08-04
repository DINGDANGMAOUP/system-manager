package com.moyun.sysmanager.domainswitcher.mapper;

import com.moyun.sysmanager.domainswitcher.entity.TabSwitchLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/** @author kuroneko */
public interface TabSwitchLogMapper extends BaseMapper<TabSwitchLog> {
    List<TabSwitchLog> findByAll(String domain);
}
