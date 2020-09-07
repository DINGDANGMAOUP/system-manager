package com.moyun.sysmanager.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class RouterDto implements Cloneable {
    private String path;

    private String component;

    private String name;

    private String metaId;

    private Integer hidden;

    private String redirect;

    @TableField("`always_show`")
    private Integer alwaysShow;

    private Integer parentId;
    MetaDto meta;
}
