package com.moyun.sysmanager.common.annotation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;


@Data
public class SysLog implements Serializable {
  @TableId(value = "id" ,type = IdType.AUTO)
  private Integer id;
  private String username;
  private String operation;
  private Integer time;
  private String method;
  private String params;
  private String ip;
  @TableField("`createTime`")
  private LocalDateTime createTime;

}
