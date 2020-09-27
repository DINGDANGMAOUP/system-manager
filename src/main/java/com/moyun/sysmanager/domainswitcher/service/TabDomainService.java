package com.moyun.sysmanager.domainswitcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDTO;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;

import java.util.List;

/** @author kuroneko */
public interface TabDomainService extends IService<TabDomain> {

  List<UsingDomain> findBySpare(Integer serviceTypeId,Integer usingServiceTypeId);

    UsingIdDTO findByUsingId(Integer serviceTypeId);
}
