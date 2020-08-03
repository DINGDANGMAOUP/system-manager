package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Slf4j
public class BaseController {

  protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
    Map<String, Object> rspData = new HashMap<>();
    rspData.put("rows", pageInfo.getRecords());
    rspData.put("total", pageInfo.getTotal());
    return rspData;
  }

  Logger logger = LoggerFactory.getLogger(BaseController.class);

}
