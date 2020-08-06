package com.moyun.sysmanager.common.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NotifyAndManagerDto  implements Serializable {
    private Integer tid;
    private String domainName;
    private LocalDateTime notifyTime;
    private String phone;
    private String name;
    private Integer state;
    private String remark;
}
