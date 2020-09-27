package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.common.pojo.NotifyAndManagerDTO;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.moyun.sysmanager.domainnamechecker.mapper.TabNotifyLogMapper;
import com.moyun.sysmanager.domainnamechecker.service.TabNotifyLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** @author kuroneko */
@Service
@DS("DNC")
public class TabNotifyLogServiceImpl extends ServiceImpl<TabNotifyLogMapper, TabNotifyLog>
    implements TabNotifyLogService {
  @Resource
  TabNotifyLogMapper tabNotifyLogMapper;

    @Override
    public List<NotifyAndManagerDTO> findByNotifyAndManager(String domainName) {
        return tabNotifyLogMapper.findByNotifyAndManager(domainName);
    }
}
