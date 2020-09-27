package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author kueoneko
 */
@Data
public class DomainsDTO implements Serializable {
    List<UsingDomain> children;

}
