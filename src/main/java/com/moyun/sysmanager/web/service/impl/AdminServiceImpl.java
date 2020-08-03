package com.moyun.sysmanager.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyun.sysmanager.web.entity.Admin;
import com.moyun.sysmanager.web.mapper.AdminMapper;
import com.moyun.sysmanager.web.service.AdminService;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService {


}
