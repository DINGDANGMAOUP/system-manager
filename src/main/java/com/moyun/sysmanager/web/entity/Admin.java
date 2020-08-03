package com.moyun.sysmanager.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Admin  implements Serializable {
    @TableId(value = "id" ,type = IdType.AUTO)
    Long id;
    String username;
    @TableField("`password`")
    String password;
    String role;
    String permission;


}
