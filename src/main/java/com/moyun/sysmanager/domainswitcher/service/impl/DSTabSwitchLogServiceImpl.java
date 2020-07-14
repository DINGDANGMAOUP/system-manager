package com.moyun.sysmanager.domainswitcher.service.impl;

import com.moyun.sysmanager.domainswitcher.entity.DSTabSwitchLog;
import com.moyun.sysmanager.domainswitcher.mapper.DSTabSwitchLogMapper;
import com.moyun.sysmanager.domainswitcher.service.DSTabSwitchLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
public class DSTabSwitchLogServiceImpl extends ServiceImpl<DSTabSwitchLogMapper, DSTabSwitchLog>
    implements DSTabSwitchLogService {}
