package com.moyun.sysmanager.common.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author dzh
 */
@Data
public class RestemplateDto implements Serializable {
  private String resUrl;
  private String newOnlineMaster;
  private String testUrl;

}
