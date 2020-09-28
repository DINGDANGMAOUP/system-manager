package com.moyun.sysmanager.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author dzh
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class  VueResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public VueResult(VueEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getDesc();
    }


    private VueResult(VueEnum vueEnum, T data) {
        this.code = vueEnum.getCode();
        this.message = vueEnum.getDesc();
        this.data = data;
    }

    public static VueResult of(VueEnum vueEnum) {
        return new VueResult<>(vueEnum);
    }

    public static VueResult of(VueEnum vueEnum, String detail) {
        return new VueResult<>(vueEnum, detail);
    }

    public static <T> VueResult of(VueEnum vueEnum, T data) {
        return new VueResult<>(vueEnum, data);
    }

    public static VueResult success() {
        return new VueResult<>(VueEnum.SUCCESS);
    }

    public static <T> VueResult success(T data) {
        return new VueResult<>(VueEnum.SUCCESS, data);
    }

    public static VueResult orderNull() {
        return new VueResult<>(VueEnum.ORDERID_NULL);
    }

    public static <T> VueResult orderNull(T data) {
        return new VueResult<>(VueEnum.ORDERID_NULL, data);
    }

    public static VueResult fail() {
        return new VueResult<>(VueEnum.SERVER_ERROR);
    }

    public static <T> VueResult fail(String detail) {
        return new VueResult<>(VueEnum.SERVER_ERROR, detail);
    }

    public static VueResult unauthorized() {
        return new VueResult<>(VueEnum.UNAUTHORIZED);
    }

    public static <T> VueResult unauthorized(String detail) {
        return new VueResult<>(VueEnum.UNAUTHORIZED, detail);
    }

    public static VueResult badRequest() {
        return new VueResult<>(VueEnum.BAD_REQUEST);
    }

    public static <T> VueResult badRequest(String detail) {
        return new VueResult<>(VueEnum.BAD_REQUEST, detail);
    }

    public static VueResult notFound() {
        return new VueResult<>(VueEnum.NOT_FOUND);
    }

    public static <T> VueResult notFound(String detail) {
        return new VueResult<>(VueEnum.NOT_FOUND, detail);
    }
}
