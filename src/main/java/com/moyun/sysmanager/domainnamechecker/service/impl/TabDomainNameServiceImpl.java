package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.domainnamechecker.entity.TabDomainName;
import com.moyun.sysmanager.domainnamechecker.mapper.TabDomainNameMapper;
import com.moyun.sysmanager.domainnamechecker.service.TabDomainNameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DNC")
public class TabDomainNameServiceImpl
    extends ServiceImpl<TabDomainNameMapper, TabDomainName>
    implements TabDomainNameService {
  @Resource
  TabDomainNameMapper dncTabDomainNameMapper;

  @Override
  public List<TabDomainName> listSort() {
    List<TabDomainName> dncTabDomainNames =
        dncTabDomainNameMapper.selectList(
            Wrappers.<TabDomainName>lambdaQuery().select().orderByAsc(TabDomainName::getTid));
    return dncTabDomainNames;
  }

  @Override
  public List<TabDomainName> search(String domainName) {
    List<TabDomainName> searchList =
        dncTabDomainNameMapper.selectList(
            Wrappers.<TabDomainName>lambdaQuery()
                .like(TabDomainName::getDomainName, domainName));
    return searchList;
  }
}
