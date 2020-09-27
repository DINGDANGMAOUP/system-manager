package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShortUrlDTO implements Serializable {
    private String result;
    private String shortUrl;
    private String status;
}
