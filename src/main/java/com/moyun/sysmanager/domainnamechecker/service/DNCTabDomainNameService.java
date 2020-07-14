package com.moyun.sysmanager.domainnamechecker.service;

import com.moyun.sysmanager.domainnamechecker.entity.DNCTabDomainName;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/** @author kuroneko */
public interface DNCTabDomainNameService extends IService<DNCTabDomainName> {

  List<DNCTabDomainName> listSort();

  List<DNCTabDomainName> search(String domainName);
}
