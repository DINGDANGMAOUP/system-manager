package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.domainswitcher.entity.Routers;
import com.moyun.sysmanager.domainswitcher.mapper.RoutersMapper;
import com.moyun.sysmanager.domainswitcher.service.IRoutersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzh
 * @since 2020-09-01
 */
@Service
public class RoutersServiceImpl extends ServiceImpl<RoutersMapper, Routers> implements IRoutersService {
    @Resource
    RoutersMapper routersMapper;

}
