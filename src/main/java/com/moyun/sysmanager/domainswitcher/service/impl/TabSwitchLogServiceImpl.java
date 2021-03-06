package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainswitcher.entity.TabSwitchLog;
import com.moyun.sysmanager.domainswitcher.mapper.TabSwitchLogMapper;
import com.moyun.sysmanager.domainswitcher.service.TabSwitchLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** @author kuroneko */
@Service
@DS("DS")
public class TabSwitchLogServiceImpl extends ServiceImpl<TabSwitchLogMapper, TabSwitchLog>
    implements TabSwitchLogService {
    @Resource
    TabSwitchLogMapper tabSwitchLogMapper;
    @Override
    public List<TabSwitchLog> findByAll(String domain) {
        return tabSwitchLogMapper.findByAll(domain);
    }
}
