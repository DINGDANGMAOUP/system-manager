package com.moyun.sysmanager.common.pojo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @author kueoneko
 */
@Data
public class DomainsDto implements Serializable {
  List<UsingDomain> children;

}
