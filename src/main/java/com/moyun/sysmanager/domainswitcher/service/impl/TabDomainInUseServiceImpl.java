package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.common.pojo.DomainInUsDTO;
import com.moyun.sysmanager.common.pojo.DomainUsDTO;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.moyun.sysmanager.domainswitcher.mapper.TabDomainInUseMapper;
import com.moyun.sysmanager.domainswitcher.service.TabDomainInUseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
      return tabDomainInUseMapper.findByUsing(serviceTypeId);
  }

    @Override
    public List<DomainInUsDTO> findAllUsing() {
        return tabDomainInUseMapper.findAllUsing();
    }

    @Override
    public DomainUsDTO findUsingAtDomain(Integer serviceTypeId) {
        return tabDomainInUseMapper.findUsingAtDomain(serviceTypeId);
    }
}
