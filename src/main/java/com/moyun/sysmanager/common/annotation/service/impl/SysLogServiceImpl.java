package com.moyun.sysmanager.common.annotation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.common.annotation.entity.SysLog;
import com.moyun.sysmanager.common.annotation.mapper.SysLogMapper;
import com.moyun.sysmanager.common.annotation.service.SysLogService;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper,SysLog> implements SysLogService {



}