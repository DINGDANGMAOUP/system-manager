package com.moyun.sysmanager.domainswitcher.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 被屏蔽的域名记录表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabBlockedLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String domain;

    private LocalDateTime blockTime;


}
