package com.moyun.sysmanager.domainswitcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyun.sysmanager.common.pojo.DomainInUsDTO;
import com.moyun.sysmanager.common.pojo.DomainUsDTO;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;

import java.util.List;

/** @author kuroneko */
public interface TabDomainInUseService extends IService<TabDomainInUse> {


  UsingDomain findByUsing(Integer serviceTypeId);

    List<DomainInUsDTO> findAllUsing();

    DomainUsDTO findUsingAtDomain(Integer serviceTypeId);
}
