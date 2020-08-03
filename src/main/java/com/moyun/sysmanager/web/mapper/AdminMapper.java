package com.moyun.sysmanager.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyun.sysmanager.web.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface AdminMapper  extends BaseMapper<Admin> {

}
