package com.mlw.service;

import com.mlw.common.dto.SysMenuDto;
import com.mlw.entity.SysMenu;
import com.mlw.entity.SysUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PermissionService {
    SysUser findSysUserByUsername(String username);

    List<SysMenuDto> getMenus(String id);

    Set<String> findPermissionByUserId(String id);

    List<SysMenu> getAllResource();

    SysMenu selectMenuById(String id);

    int save(SysMenu sysMenu);
}
