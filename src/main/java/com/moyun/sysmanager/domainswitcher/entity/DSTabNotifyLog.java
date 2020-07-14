package com.moyun.sysmanager.domainswitcher.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 异常通知记录表
 *
 * @author kuroneko
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSTabNotifyLog implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

        @TableField("domainName")
    private String domainName;

        @TableField("notifyTime")
    private LocalDateTime notifyTime;

        @TableField("managerId")
    private Integer managerId;


}
