package com.moyun.sysmanager.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class AdminDTO {
    Long id;
    String username;
    String password;
    List roles;
    String permission;

}
