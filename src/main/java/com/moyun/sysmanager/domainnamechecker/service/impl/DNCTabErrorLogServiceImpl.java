package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainnamechecker.entity.DNCTabErrorLog;
import com.moyun.sysmanager.domainnamechecker.mapper.DNCTabErrorLogMapper;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabErrorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DNC")
public class DNCTabErrorLogServiceImpl extends ServiceImpl<DNCTabErrorLogMapper, DNCTabErrorLog>
    implements DNCTabErrorLogService {}
