package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainnamechecker.entity.DNCTabNotifyLog;
import com.moyun.sysmanager.domainnamechecker.mapper.DNCTabNotifyLogMapper;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabNotifyLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author kuroneko
 */
@Service
@DS("DNC")
public class DNCTabNotifyLogServiceImpl extends ServiceImpl<DNCTabNotifyLogMapper, DNCTabNotifyLog> implements
    DNCTabNotifyLogService {

}
