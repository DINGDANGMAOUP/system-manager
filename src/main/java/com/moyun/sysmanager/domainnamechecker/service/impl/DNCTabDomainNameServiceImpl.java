package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.domainnamechecker.entity.DNCTabDomainName;
import com.moyun.sysmanager.domainnamechecker.mapper.DNCTabDomainNameMapper;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabDomainNameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DNC")
public class DNCTabDomainNameServiceImpl
    extends ServiceImpl<DNCTabDomainNameMapper, DNCTabDomainName>
    implements DNCTabDomainNameService {
  @Resource DNCTabDomainNameMapper dncTabDomainNameMapper;

  @Override
  public List<DNCTabDomainName> listSort() {
    List<DNCTabDomainName> dncTabDomainNames =
        dncTabDomainNameMapper.selectList(
            Wrappers.<DNCTabDomainName>lambdaQuery().select().orderByAsc(DNCTabDomainName::getTid));
    return dncTabDomainNames;
  }

  @Override
  public List<DNCTabDomainName> search(String domainName) {
    List<DNCTabDomainName> searchList =
        dncTabDomainNameMapper.selectList(
            Wrappers.<DNCTabDomainName>lambdaQuery()
                .like(DNCTabDomainName::getDomainName, domainName));
    return searchList;
  }
}
