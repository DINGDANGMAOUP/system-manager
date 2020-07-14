package com.moyun.sysmanager.domainswitcher.service.impl;

import com.moyun.sysmanager.domainswitcher.entity.DSTabServiceType;
import com.moyun.sysmanager.domainswitcher.mapper.DSTabServiceTypeMapper;
import com.moyun.sysmanager.domainswitcher.service.DSTabServiceTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
public class DSTabServiceTypeServiceImpl
    extends ServiceImpl<DSTabServiceTypeMapper, DSTabServiceType>
    implements DSTabServiceTypeService {}
