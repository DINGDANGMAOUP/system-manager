package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.common.pojo.DomainInUsDto;
import com.moyun.sysmanager.common.pojo.DomainUsDto;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.moyun.sysmanager.domainswitcher.mapper.TabDomainInUseMapper;
import com.moyun.sysmanager.domainswitcher.service.TabDomainInUseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabDomainInUseServiceImpl
    extends ServiceImpl<TabDomainInUseMapper, TabDomainInUse>
    implements TabDomainInUseService {
@Resource
TabDomainInUseMapper tabDomainInUseMapper;

  @Override
  public UsingDomain findByUsing(Integer serviceTypeId) {
    UsingDomain usingDomains= tabDomainInUseMapper.findByUsing(serviceTypeId);
    return usingDomains;
  }

  @Override
  public List<DomainInUsDto> findAllUsing() {
    return tabDomainInUseMapper.findAllUsing();
  }

  @Override
  public DomainUsDto findUsingAtDomain(Integer serviceTypeId) {
    return tabDomainInUseMapper.findUsingAtDomain(serviceTypeId);
  }
}
