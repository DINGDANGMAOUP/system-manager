package com.moyun.sysmanager.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class RouterDTO implements Cloneable {
    private String path;

    private String component;

    private String name;

    private String metaId;

    private String hidden;

    private String redirect;

    @TableField("`always_show`")
    private String alwaysShow;

    private String parentId;
    MetaDTO meta;
}
