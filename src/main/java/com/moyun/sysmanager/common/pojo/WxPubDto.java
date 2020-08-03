package com.moyun.sysmanager.common.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/** 微信公众号监控pojo */
@Data
public class WxPubDto {
  // 序号
  private Integer id;
  // 域名
  private String domain;
  // 状态
  private Integer state;
  // 是否正在使用
  @Value(value = "false")
  private boolean using;

  public WxPubDto(Integer id, String domain, Integer state, boolean using) {
    this.id = id;
    this.domain = domain;
    this.state = state;
    this.using = using;
  }
}
