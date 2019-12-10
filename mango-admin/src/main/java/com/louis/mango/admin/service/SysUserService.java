package com.louis.mango.admin.service;

import com.louis.mango.admin.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();

}