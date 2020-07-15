package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainswitcher.entity.TabBlockedLog;
import com.moyun.sysmanager.domainswitcher.mapper.TabBlockedLogMapper;
import com.moyun.sysmanager.domainswitcher.service.TabBlockedLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabBlockedLogServiceImpl extends ServiceImpl<TabBlockedLogMapper, TabBlockedLog>
    implements TabBlockedLogService {}
