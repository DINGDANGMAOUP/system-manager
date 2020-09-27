package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDTO;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.domainswitcher.mapper.TabDomainMapper;
import com.moyun.sysmanager.domainswitcher.service.TabDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** @author kuroneko */
@Service
@DS("DS")
public class TabDomainServiceImpl extends ServiceImpl<TabDomainMapper, TabDomain>
    implements TabDomainService {
@Resource
TabDomainMapper tabDomainMapper;
  @Override
  public List<UsingDomain> findBySpare(Integer serviceTypeId,Integer usingServiceTypeId) {
      return tabDomainMapper.findBySpare(serviceTypeId, usingServiceTypeId);
  }

    @Override
    public UsingIdDTO findByUsingId(Integer serviceTypeId) {
        return tabDomainMapper.findByUsingId(serviceTypeId);
    }
}
