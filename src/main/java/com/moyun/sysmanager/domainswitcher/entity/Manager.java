package com.moyun.sysmanager.domainswitcher.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tab_manager")
public class Manager implements Serializable {

    /**
     * 管理员表ID
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;


    @Pattern(regexp = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$", message = "手机号格式错误")
    /** 管理员手机号码 */
    private String phone;

    @NotBlank
    /** 管理员姓名 */
    private String name;

    @NotNull
    /** 管理员状态（0：禁用|1：启用） */
    private Integer state;

    /**
     * 备注
     */
    private String remark;
}
