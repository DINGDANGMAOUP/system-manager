package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dzh
 */
@Data
public class NotifyAndManagerDTO implements Serializable {
    private Integer tid;
    private String domainName;
    private LocalDateTime notifyTime;
    private String phone;
    private String name;
    private Integer state;
    private String remark;
}
