package com.moyun.sysmanager.domainnamechecker.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainnamechecker.entity.DNCTabManager;
import com.moyun.sysmanager.domainnamechecker.mapper.DNCTabManagerMapper;
import com.moyun.sysmanager.domainnamechecker.service.DNCTabManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author kuroneko
 */
@Service
@DS("DNC")
public class DNCTabManagerServiceImpl extends ServiceImpl<DNCTabManagerMapper, DNCTabManager> implements
    DNCTabManagerService {

}
