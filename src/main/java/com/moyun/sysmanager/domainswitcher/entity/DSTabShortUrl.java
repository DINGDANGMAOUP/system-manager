package com.moyun.sysmanager.domainswitcher.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 短网址表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabShortUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 短网址代码
     */
    private String shortUrlCode;

    private Integer domainId;

    private String serviceLocation;


}
