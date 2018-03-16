package com.mlw.service.Impl;

import com.mlw.entity.SysUser;
import com.mlw.entity.SysUserExample;
import com.mlw.mapper.SysMenuMapper;
import com.mlw.mapper.SysUserMapper;
import com.mlw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    public SysUser findSysUserByUsername(String username) {

        List<SysUser> list=sysUserMapper.findSysUserByUsername(username);

        if (list!=null&&list.size()==1)
        {
            return list.get(0);
        }
        return null;
    }

    public Map<String, Object> getMenus(String id) {
        return sysMenuMapper.getMenus(id);
    }

    public Set<String> findPermissionByUserId(String id) {
        return sysMenuMapper.findPermissionByUserId(id);
    }
}
