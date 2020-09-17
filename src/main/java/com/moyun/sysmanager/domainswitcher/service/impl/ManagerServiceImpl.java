package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.domainswitcher.entity.Manager;
import com.moyun.sysmanager.domainswitcher.mapper.ManagerMapper;
import com.moyun.sysmanager.domainswitcher.service.ManagerService;
import org.springframework.stereotype.Service;

/**
 * @author dzh
 */
@Service
@DS("DS")
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

}
