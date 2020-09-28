package com.moyun.sysmanager.domainnamechecker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.moyun.sysmanager.Constants.PHONE;

/**
 * 管理员表（即需要短信通知的人员）
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tab_manager")
public class TabManager implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 管理员表ID */
  @TableId(value = "tid", type = IdType.AUTO)
  private Integer tid;


  @Pattern(regexp = PHONE,message = "手机号格式错误")
  /** 管理员手机号码 */
  private String phone;

  @NotBlank
  /** 管理员姓名 */
  private String name;

  @NotNull
  /** 管理员状态（0：禁用|1：启用） */
  private Integer state;

  /** 备注 */
  private String remark;
}
