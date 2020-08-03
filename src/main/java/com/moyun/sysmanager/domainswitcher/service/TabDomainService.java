package com.moyun.sysmanager.domainswitcher.service;

import com.moyun.sysmanager.common.pojo.UsingDomain;
import com.moyun.sysmanager.common.pojo.UsingIdDto;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/** @author kuroneko */
public interface TabDomainService extends IService<TabDomain> {

  List<UsingDomain> findBySpare(Integer serviceTypeId,Integer usingServiceTypeId);

  UsingIdDto findByUsingId(Integer serviceTypeId);
}
