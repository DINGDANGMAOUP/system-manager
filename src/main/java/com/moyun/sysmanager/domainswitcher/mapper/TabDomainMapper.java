package com.moyun.sysmanager.domainswitcher.mapper;

import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDto;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/** @author kuroneko */
public interface TabDomainMapper extends BaseMapper<TabDomain> {

  List<UsingDomain> findBySpare(Integer serviceTypeId,Integer usingServiceTypeId);

  UsingIdDto findByUsingId(Integer serviceTypeId);
}
