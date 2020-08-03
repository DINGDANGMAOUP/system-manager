package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainswitcher.entity.TabServiceType;
import com.moyun.sysmanager.domainswitcher.mapper.TabServiceTypeMapper;
import com.moyun.sysmanager.domainswitcher.service.TabServiceTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabServiceTypeServiceImpl
    extends ServiceImpl<TabServiceTypeMapper, TabServiceType>
    implements TabServiceTypeService {}
