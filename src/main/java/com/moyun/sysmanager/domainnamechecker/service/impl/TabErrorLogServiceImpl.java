package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainnamechecker.entity.TabErrorLog;
import com.moyun.sysmanager.domainnamechecker.mapper.TabErrorLogMapper;
import com.moyun.sysmanager.domainnamechecker.service.TabErrorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DNC")
public class TabErrorLogServiceImpl extends ServiceImpl<TabErrorLogMapper, TabErrorLog>
    implements TabErrorLogService {}
