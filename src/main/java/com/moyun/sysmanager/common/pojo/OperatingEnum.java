package com.moyun.sysmanager.common.pojo;

public enum OperatingEnum {
  SWITCH("切换"),BLOCK("屏蔽");
  private String operating;

  OperatingEnum(String operating) {
    this.operating = operating;
  }

  public String getOperating() {
    return operating;
  }
}
