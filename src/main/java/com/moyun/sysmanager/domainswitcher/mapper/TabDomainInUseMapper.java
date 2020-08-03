package com.moyun.sysmanager.domainswitcher.mapper;

import com.moyun.sysmanager.common.pojo.DomainInUsDto;
import com.moyun.sysmanager.common.pojo.DomainUsDto;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/** @author kuroneko */
public interface TabDomainInUseMapper extends BaseMapper<TabDomainInUse> {

  UsingDomain findByUsing(Integer serviceTypeId);

  List<DomainInUsDto> findAllUsing();

  DomainUsDto findUsingAtDomain(Integer serviceTypeId);
}
