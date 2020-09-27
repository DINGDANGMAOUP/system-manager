package com.moyun.sysmanager.domainswitcher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDTO;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;

import java.util.List;

/** @author kuroneko */
public interface TabDomainMapper extends BaseMapper<TabDomain> {

  List<UsingDomain> findBySpare(Integer serviceTypeId,Integer usingServiceTypeId);

    UsingIdDTO findByUsingId(Integer serviceTypeId);
}
