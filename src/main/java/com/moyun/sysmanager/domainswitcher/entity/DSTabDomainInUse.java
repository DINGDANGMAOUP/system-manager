package com.moyun.sysmanager.domainswitcher.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 使用中的域名表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabDomainInUse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信appid
     */
    private String wxAppid;

    /**
     * 服务类型id
     */
    private String wxName;

    /**
     * 域名id
     */
    private Integer domainId;


}
