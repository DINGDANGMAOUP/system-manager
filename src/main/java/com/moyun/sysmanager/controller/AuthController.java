package com.moyun.sysmanager.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.utils.JWTUtil;
import com.moyun.sysmanager.web.entity.Admin;
import com.moyun.sysmanager.web.entity.AdminDTO;
import com.moyun.sysmanager.web.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dzh
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class AuthController {

    @Resource AdminService adminService;

    @Log("管理员登入")
    @PostMapping("user")
    public VueResult login(
            @RequestBody @NotNull(message = "账户密码为空") Admin admin, HttpServletResponse response) {
        Admin res =
                adminService.getOne(
                        Wrappers.<Admin>lambdaQuery()
                                .eq(Admin::getUsername, admin.getUsername())
                                .eq(Admin::getPassword, admin.getPassword()));
        if (ObjectUtils.isEmpty(res)) {
            log.info("登入失败");
            return VueResult.fail("用户不存在");
        }
        String token = JWTUtil.sign(admin.getUsername(), admin.getPassword());
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);
        HashMap<Object, Object> map = new HashMap<>(1);
        map.put("token", token);

        return VueResult.success(map);
    }

    @GetMapping("/UseInfo")
    public VueResult getUserInfo(String token) {
        String username = JWTUtil.getUsername(token);
        Admin admin = adminService.getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername, username));
        AdminDTO adDto = new AdminDTO();
        ArrayList<Object> list = new ArrayList<>();
        list.add(admin.getRole());
        adDto.setId(admin.getId());
        adDto.setPermission(admin.getPermission());
        adDto.setRoles(list);
        return VueResult.success(adDto);
    }

    @Log("管理员登出")
    @PostMapping("/logout")
    public VueResult logout() {
        return VueResult.success();
    }
}
