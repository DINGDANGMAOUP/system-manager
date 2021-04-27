package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.domainnamechecker.entity.TabDomainName;
import com.moyun.sysmanager.domainnamechecker.mapper.TabDomainNameMapper;
import com.moyun.sysmanager.domainnamechecker.service.TabDomainNameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    
      return dncTabDomainNameMapper.selectList(
              Wrappers.<TabDomainName>lambdaQuery().select().orderByAsc(TabDomainName::getTid));
  }

  @Override
  public List<TabDomainName> search(String domainName) {
      return dncTabDomainNameMapper.selectList(
              Wrappers.<TabDomainName>lambdaQuery()
                      .like(TabDomainName::getDomainName, domainName));
  }
}
