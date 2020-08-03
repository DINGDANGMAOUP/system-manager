package com.moyun.sysmanager.common.result;

public enum VueEnum {
    SUCCESS(20000, "success"),
    ILLEGAL_OPERATION(20001, "ILLEGAL_OPERATION"),
    SERVER_ERROR(50000, "server_error"),
    BAD_REQUEST(40000, "bad_request"),
    UNAUTHORIZED(40001, "unauthorized"),
    NOT_FOUND(40004, "not_found"),
    WRONG_PASSWORD(50001,"wrong_password"),
    UNKNOWN(60000,"unknown"),
    ENABLE_FAILURE(80001,"enable_failure");
    private int code;
    private String desc;

    VueEnum(int code, String desc) {
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
