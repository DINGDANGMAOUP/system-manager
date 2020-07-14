package com.moyun.sysmanager.domainswitcher.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 服务类型表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabServiceType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务的类型：普通结果页链接，天降吉名结果页链接等
     */
    private String serviceType;

    /**
     * 用于什么地方：菜单：menu|公众号服务器内部：inside
     */
    private String serviceLocation;


}
