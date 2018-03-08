package com.mlw.service.Impl;

import com.mlw.entity.SysUser;
import com.mlw.mapper.SysUserMapper;
import com.mlw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser findSysUserByUsername(String username) {
        return sysUserMapper.findSysUserByUsername(username);
    }
}
