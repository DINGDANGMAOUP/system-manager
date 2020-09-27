package com.moyun.sysmanager.domainnamechecker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyun.sysmanager.common.pojo.NotifyAndManagerDTO;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;

import java.util.List;

/** @author kuroneko */
public interface TabNotifyLogMapper extends BaseMapper<TabNotifyLog> {

    List<NotifyAndManagerDTO> findByNotifyAndManager(String domainName);
}
