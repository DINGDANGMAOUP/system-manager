package com.moyun.sysmanager.domainnamechecker.service;

import com.moyun.sysmanager.domainnamechecker.entity.TabDomainName;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/** @author kuroneko */
public interface TabDomainNameService extends IService<TabDomainName> {

  List<TabDomainName> listSort();

  List<TabDomainName> search(String domainName);
}
