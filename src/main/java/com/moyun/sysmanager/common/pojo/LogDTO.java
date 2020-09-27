package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dzh
 */
@Data
public class LogDTO implements Serializable {
    private Integer num;
    private String manager;
    private String domainName;
    private String Operating;
    private LocalDateTime OperatingTime;
    private String errorDesc;

}
