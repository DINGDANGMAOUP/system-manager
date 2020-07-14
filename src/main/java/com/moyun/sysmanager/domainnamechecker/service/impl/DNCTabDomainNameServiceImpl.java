package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainnamechecker.entity.DNCTabDomainName;
import com.moyun.sysmanager.domainnamechecker.mapper.DNCTabDomainNameMapper;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabDomainNameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author kuroneko
 */
@Service
@DS("DNC")
public class DNCTabDomainNameServiceImpl extends ServiceImpl<DNCTabDomainNameMapper, DNCTabDomainName> implements
    DNCTabDomainNameService {

}
