package com.moyun.sysmanager.common.result;

import java.util.List;
import lombok.Data;

@Data
public class ViewResult<T> {
  private Integer code;
  private String msg;
  private Long count;
  private T data;

  private static ViewResult of() {
    return new ViewResult();
  }

  public static  ViewResult success() {
    ViewResult of = ViewResult.of();
    of.setMsg("success");
    return of;
  }
}
