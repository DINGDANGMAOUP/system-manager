package com.moyun.sysmanager.domainswitcher.service;

import com.moyun.sysmanager.common.pojo.DomainInUsDto;
import com.moyun.sysmanager.common.pojo.DomainUsDto;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/** @author kuroneko */
public interface TabDomainInUseService extends IService<TabDomainInUse> {


  UsingDomain findByUsing(Integer serviceTypeId);

  List<DomainInUsDto> findAllUsing();

  DomainUsDto findUsingAtDomain(Integer serviceTypeId);
}
