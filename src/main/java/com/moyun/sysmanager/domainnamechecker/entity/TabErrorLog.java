package com.moyun.sysmanager.domainnamechecker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 域名异常记录表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tab_error_log")
public class TabErrorLog implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 异常表ID */
  @TableId(value = "tid", type = IdType.AUTO)
  private Integer tid;

  /** 异常的域名或URL */
  @TableField("domainName")
  private String domainName;

  /** 异常说明 */
  @TableField("errorContent")
  private String errorContent;

  @TableField("errorTime")
  private LocalDateTime errorTime;
}
