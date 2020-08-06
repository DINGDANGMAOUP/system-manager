package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DomainInUsDto  implements Serializable {

  private Integer id;
  /** 微信appid */
  private String wxAppid;
  private String wxName;
  private String domain;
  private Integer state;
  private String serviceTypeId;

}
