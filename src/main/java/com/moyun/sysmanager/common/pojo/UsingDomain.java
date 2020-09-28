package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.moyun.sysmanager.Constants.DOMAIN;

/** @author kueoneko */
@Data
public class UsingDomain implements Serializable {
  private Integer id;

  @NotBlank(message = "不能为空")
  @Pattern(regexp = DOMAIN, message = "请输入正确的域名")
  private String domain;

  private Integer state;
  private Integer serviceTypeId;
  private boolean using;
}
