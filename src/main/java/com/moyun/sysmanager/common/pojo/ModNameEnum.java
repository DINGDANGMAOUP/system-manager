package com.moyun.sysmanager.common.pojo;

public enum ModNameEnum {
  RESURL("resUrl"),
  OLQM("olqm"),
  MSTR("mstr"),
  NEWONLINEMASTER("newOnlineMaster"),
  TESTURL("testUrl");
  private String serviceType;

  ModNameEnum(String serviceType) {
    this.serviceType = serviceType;
  }

  public String getServiceType() {
    return serviceType;
  }
}
