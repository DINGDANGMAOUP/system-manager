package com.moyun.sysmanager.common.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author dzh
 */
@Data
public class LogDto implements Serializable {
  private Integer num;
  private String manager;
  private String domainName;
  private String Operating;
  private LocalDateTime OperatingTime;
  private String errorDesc;

}
