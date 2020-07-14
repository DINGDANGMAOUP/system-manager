package com.moyun.sysmanager.domainswitcher.service.impl;

import com.moyun.sysmanager.domainswitcher.entity.DSTabErrorLog;
import com.moyun.sysmanager.domainswitcher.mapper.DSTabErrorLogMapper;
import com.moyun.sysmanager.domainswitcher.service.DSTabErrorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
public class DSTabErrorLogServiceImpl extends ServiceImpl<DSTabErrorLogMapper, DSTabErrorLog>
    implements DSTabErrorLogService {}
