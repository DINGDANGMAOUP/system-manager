package com.moyun.sysmanager.domainnamechecker.controller;


import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.utils.JWTUtil;
import com.moyun.sysmanager.web.entity.AdDto;
import com.moyun.sysmanager.web.entity.Admin;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuroneko
 */
@RestController
//@RequestMapping("domain/tdn")
public class DNCTabDomainNameController {
  @Log("管理员登入")
  @PostMapping("user")
  public VueResult login(
      @RequestBody @NotNull(message = "账户密码为空") Admin admin, HttpServletResponse response) {
    Admin res =null;
//        adminService.getOne(
//            Wrappers.<Admin>lambdaQuery()
//                .eq(Admin::getUsername, admin.getUsername())
//                .eq(Admin::getPassword, admin.getPassword()));
    if (ObjectUtils.isEmpty(res)){
//      log.info("登入失败");
      return VueResult.fail("用户不存在");
    }
    String Token = JWTUtil.sign(admin.getUsername(), admin.getPassword());
    Cookie cookie = new Cookie("token", Token);
    response.addCookie(cookie);
    HashMap<Object, Object> map = new HashMap<>();
    map.put("token", Token);

    return VueResult.success(map);
  }

  @GetMapping("/UseInfo")
  public VueResult getUserInfo(String token) {
    String username = JWTUtil.getUsername(token);
    Admin one = null;
    AdDto adDto = new AdDto();
    ArrayList<Object> list = new ArrayList<>();
    list.add("admin");
    adDto.setId(one.getId());
    adDto.setPermission(one.getPermission());
    adDto.setRoles(list);
    return VueResult.success(adDto);
  }

  @Log("管理员登出")
  @PostMapping("/logout")
  public VueResult logout() {
    return VueResult.success();
  }
}
