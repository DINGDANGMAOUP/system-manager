package com.moyun.sysmanager.common.pojo;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/** @author dzh */
@Data
public class WxModDto {
  // 模块名
  private String serviceType;
  // 域名对象
  List children;

  public WxModDto(ModNameEnum modNameEnum) {
    this.serviceType = modNameEnum.getServiceType();
    this.children = new ArrayList();
  }

  public static WxModDto of(ModNameEnum modNameEnum) {
    return new WxModDto(modNameEnum);
  }

  public static WxModDto resUrl() {
    return new WxModDto(ModNameEnum.RESURL);
  }

  public static WxModDto olqm() {
    return new WxModDto(ModNameEnum.OLQM);
  }

  public static WxModDto mstr() {
    return new WxModDto(ModNameEnum.MSTR);
  }

  public static WxModDto newOnlineMaster() {
    return new WxModDto(ModNameEnum.NEWONLINEMASTER);
  }

  public static WxModDto testUrl() {
    return new WxModDto(ModNameEnum.TESTURL);
  }
}
