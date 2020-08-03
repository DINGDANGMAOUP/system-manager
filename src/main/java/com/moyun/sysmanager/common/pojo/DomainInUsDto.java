package com.moyun.sysmanager.common.pojo;

import lombok.Data;

@Data
public class DomainInUsDto {

  private Integer id;
  /** 微信appid */
  private String wxAppid;
  private String wxName;
  private String domain;
  private Integer state;
  private String serviceTypeId;

}
