package com.moyun.sysmanager.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class RouterDTO implements Cloneable {
    private String path;

    private String component;

    private String name;

    private String metaId;

    private Integer hidden;

    private String redirect;

    @TableField("`always_show`")
    private Integer alwaysShow;

    private Integer parentId;
    MetaDTO meta;
}
