package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainnamechecker.entity.TabManager;
import com.moyun.sysmanager.domainnamechecker.mapper.TabManagerMapper;
import com.moyun.sysmanager.domainnamechecker.service.TabManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DNC")
public class TabManagerServiceImpl extends ServiceImpl<TabManagerMapper, TabManager>
    implements TabManagerService {}
