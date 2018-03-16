package com.mlw.service;

import com.mlw.entity.SysUser;

import java.util.Map;
import java.util.Set;

public interface PermissionService {
    SysUser findSysUserByUsername(String username);

    Map<String,Object> getMenus(String id);

    Set<String> findPermissionByUserId(String id);
}
