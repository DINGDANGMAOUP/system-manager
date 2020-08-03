package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.common.pojo.NotifyAndManagerDto;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.moyun.sysmanager.domainnamechecker.mapper.TabNotifyLogMapper;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DNC")
public class TabNotifyLogServiceImpl extends ServiceImpl<TabNotifyLogMapper, TabNotifyLog>
    implements TabNotifyLogService {
  @Resource
  TabNotifyLogMapper tabNotifyLogMapper;

  @Override
  public List<NotifyAndManagerDto> findByNotifyAndManager() {
    List<NotifyAndManagerDto> list=  tabNotifyLogMapper.findByNotifyAndManager();
    return list;
  }
}
