package com.moyun.sysmanager.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class Tree<T> {

  private String id;

  private String path;

  private String component;

  private String name;

  private String metaId;

  private String hidden;

  private String redirect;

  @TableField("`always_show`")
  private String alwaysShow;

  private String parentId;

  private List<Tree<T>> children;


  public  void initChildren() {
    this.children = new ArrayList<>();
  }
}