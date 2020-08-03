package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.common.result.ResultEnum;
import com.moyun.sysmanager.utils.JWTUtil;
import com.moyun.sysmanager.web.entity.AdDto;
import com.moyun.sysmanager.web.entity.Admin;
import com.moyun.sysmanager.web.service.AdminService;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthController {

  @Resource AdminService adminService;

  @PostMapping("user")
  public Result login(
      @RequestBody @NotNull(message = "账户密码为空") Admin admin, HttpServletResponse response) {
    Admin res =
        adminService.getOne(
            Wrappers.<Admin>lambdaQuery()
                .eq(Admin::getUsername, admin.getUsername())
                .eq(Admin::getPassword, admin.getPassword()));
    //      if (res==null){
    //          return Result.unauthorized();
    //      }
    String Token = JWTUtil.sign(admin.getUsername(), admin.getPassword());
    Cookie cookie = new Cookie("token", Token);
    response.addCookie(cookie);
    HashMap<Object, Object> map = new HashMap<>();
    map.put("token", Token);
    Result<Object> result = new Result<>();
    result.setCode(20000);
    result.setData(map);
    return result;
  }

  @GetMapping("/UseInfo")
  public Result getUserInfo(String token) {
    String username = JWTUtil.getUsername(token);
    Admin one = adminService.getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername, username));
    Result<Object> result = new Result<>();
    result.setCode(20000);
    AdDto adDto = new AdDto();
    ArrayList<Object> list = new ArrayList<>();
    list.add("admin");
    adDto.setId(one.getId());
    adDto.setPermission(one.getPermission());
    adDto.setRoles(list);
    result.setData(adDto);

    return result;
  }

  @PostMapping("/logout")
  public Result logout() {
    Result<Object> result = new Result<>();
    result.setCode(20000);
    return result;
  }
  //  @GetMapping("/auth")
  //  public Result getToken(@RequestBody Admin admin, HttpServletResponse response){
  //    if (admin==null){
  //      return Result.fail();
  //    }
  //    Admin res = adminService.getOne(
  //        Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername, admin.getUsername())
  //            .eq(Admin::getPassword, admin.getPassword()));
  //    if (res==null){
  //      return Result.unauthorized();
  //    }
  //    String Token= JWTUtil.sign(admin.getUsername(),admin.getPassword());
  //    Cookie cookie = new Cookie("token",Token);
  //    response.addCookie(cookie);
  //    return  Result.success();
  //  }

}
