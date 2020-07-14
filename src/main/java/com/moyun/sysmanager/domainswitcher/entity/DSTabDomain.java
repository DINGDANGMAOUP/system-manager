package com.moyun.sysmanager.domainswitcher.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 域名表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务类型id
     */
    private Integer serviceTypeId;

    /**
     * 域名
     */
    private String domain;

    /**
     * 域名状态（1=可用：0=不可用）
     */
    private Boolean state;

    /**
     * 威信短网址
     */
    private String wxShortUrl;

    /**
     * 威信短网址第二级检测
     */
    private String wxShortUrlTwo;


}
