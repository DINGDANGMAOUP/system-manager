package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDto;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.domainswitcher.mapper.TabDomainMapper;
import com.moyun.sysmanager.domainswitcher.service.TabDomainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabDomainServiceImpl extends ServiceImpl<TabDomainMapper, TabDomain>
    implements TabDomainService {
@Resource
TabDomainMapper tabDomainMapper;
  @Override
  public List<UsingDomain> findBySpare(Integer serviceTypeId,Integer usingServiceTypeId) {
    List<UsingDomain> usingDomains= tabDomainMapper.findBySpare(serviceTypeId,usingServiceTypeId);
    return usingDomains;
  }

  @Override
  public UsingIdDto findByUsingId(Integer serviceTypeId) {
    return tabDomainMapper.findByUsingId(serviceTypeId);
  }
}
