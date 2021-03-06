package com.moyun.sysmanager.domainswitcher.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.moyun.sysmanager.Constants.DOMAIN;

/**
 * 域名表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TabDomain implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /** 服务类型id */
  private Integer serviceTypeId;

  /** 域名 */
  @NotBlank
  @Pattern(regexp = DOMAIN, message = "请输入正确的域名")
  private String domain;

  @NotNull
  /** 域名状态（1=可用：0=不可用） */
  private Integer state;

  @NotNull
  /** 威信短网址 */
  private String wxShortUrl;

  @NotNull
  /** 威信短网址第二级检测 */
  private String wxShortUrlTwo;
}
