package com.louis.mango.admin.controller;

import com.louis.mango.admin.constant.SysConstants;
import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.admin.util.PasswordUtils;
import com.louis.mango.admin.util.SecurityUtils;
import com.louis.mango.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findByName")
    public HttpResult findByUserName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    /**
     * 修改密码
     * @param password
     * @param newPassword
     * @return
     */
    @PreAuthorize("hasAuthority('sys:user:edit')")
    @GetMapping(value="/updatePassword")
    public HttpResult updatePassword(@RequestParam String password, @RequestParam String newPassword) {
        SysUser user = sysUserService.findByName(SecurityUtils.getUsername());
        if(user == null) {
            HttpResult.error("用户不存在!");
        }else {
            if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
            if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
                return HttpResult.error("原密码不正确!");
            }
            user.setPassword(PasswordUtils.encode(newPassword, user.getSalt()));
        }
        return HttpResult.ok(sysUserService.save(user));
    }
}
