package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dzh
 */
@Data
public class NotifyDTO implements Serializable {
    private Integer num;
    private String manager;
    private String phone;
    private Integer state;

}
