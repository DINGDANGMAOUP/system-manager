package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author dzh
 */
@Data
public class MetaDto {
    private String tittle;

    private String icon;

    private Integer noCache;

    private Integer breadcrumb;

    private Integer affix;

    private String activeMenu;
    List<RoleDto> roles;


}
