package com.moyun.sysmanager.domainnamechecker.mapper;

import com.moyun.sysmanager.common.pojo.NotifyAndManagerDto;
import com.moyun.sysmanager.domainnamechecker.entity.TabNotifyLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/** @author kuroneko */
public interface TabNotifyLogMapper extends BaseMapper<TabNotifyLog> {

  List<NotifyAndManagerDto> findByNotifyAndManager();
}
