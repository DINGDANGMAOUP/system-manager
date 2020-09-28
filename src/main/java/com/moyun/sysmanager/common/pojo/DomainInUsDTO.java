package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dzh
 */
@Data
public class DomainInUsDTO implements Serializable {

    private Integer id;
    /**
     * 微信appid
     */
    private String wxAppid;
    private String wxName;
    private String domain;
    private Integer state;
    private String serviceTypeId;

}
