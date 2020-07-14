package com.moyun.sysmanager.domainswitcher.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 域名替换日志记录表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabSwitchLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String originDomain;

    private String newDomain;

    private LocalDateTime switchTime;

    private Integer switchResult;


}
