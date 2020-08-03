package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author kueoneko
 */
@Data
public class UsingDomain implements Serializable {
  private Integer id;
  @NotBlank(message = "不能为空")
  @Pattern(
          regexp =
                  "^(?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*$",message = "请输入正确的域名")
  private String domain;
  private Integer state;
  private Integer serviceTypeId;
  private boolean using;

}
