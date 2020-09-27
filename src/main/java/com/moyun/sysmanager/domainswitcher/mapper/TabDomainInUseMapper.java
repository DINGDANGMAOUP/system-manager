package com.moyun.sysmanager.domainswitcher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyun.sysmanager.common.pojo.DomainInUsDTO;
import com.moyun.sysmanager.common.pojo.DomainUsDTO;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;

import java.util.List;

/** @author kuroneko */
public interface TabDomainInUseMapper extends BaseMapper<TabDomainInUse> {

  UsingDomain findByUsing(Integer serviceTypeId);

    List<DomainInUsDTO> findAllUsing();

    DomainUsDTO findUsingAtDomain(Integer serviceTypeId);
}
