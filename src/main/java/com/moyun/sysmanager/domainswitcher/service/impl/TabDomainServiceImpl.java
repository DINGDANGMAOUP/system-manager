package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.domainswitcher.mapper.TabDomainMapper;
import com.moyun.sysmanager.domainswitcher.service.TabDomainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabDomainServiceImpl extends ServiceImpl<TabDomainMapper, TabDomain>
    implements TabDomainService {}
