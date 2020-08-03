package com.moyun.sysmanager.common.result;

public enum ResultEnum {
  SUCCESS(200, "success"),
  ILLEGAL_OPERATION(201, "ILLEGAL_OPERATION"),
  SERVER_ERROR(500, "server_error"),
  BAD_REQUEST(400, "bad_request"),
  UNAUTHORIZED(401, "unauthorized"),
  NOT_FOUND(404, "not_found"),
  WRONG_PASSWORD(501,"wrong_password"),
  UNKNOWN(600,"UNKNOWN");
  private int code;
  private String desc;

  ResultEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
