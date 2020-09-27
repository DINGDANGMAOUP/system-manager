package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dzh
 */
@Data
public class RestemplateDTO implements Serializable {
    private String resUrl;
    private String newOnlineMaster;
    private String testUrl;

}
