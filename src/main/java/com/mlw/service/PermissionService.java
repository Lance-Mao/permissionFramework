package com.mlw.service;

import com.mlw.entity.SysMenu;
import com.mlw.entity.SysUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PermissionService {
    SysUser findSysUserByUsername(String username);

    List<SysMenu> getMenus(String id);

    Set<String> findPermissionByUserId(String id);
}
