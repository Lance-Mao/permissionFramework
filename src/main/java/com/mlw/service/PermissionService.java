package com.mlw.service;

import com.mlw.entity.SysUser;

public interface PermissionService {
    SysUser findSysUserByUsername(String username);
}
