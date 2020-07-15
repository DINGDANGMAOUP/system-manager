package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.moyun.sysmanager.domainswitcher.mapper.TabDomainInUseMapper;
import com.moyun.sysmanager.domainswitcher.service.TabDomainInUseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabDomainInUseServiceImpl
    extends ServiceImpl<TabDomainInUseMapper, TabDomainInUse>
    implements TabDomainInUseService {}
