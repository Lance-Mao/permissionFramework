package com.mlw.service.Impl;

import com.mlw.mapper.SysRoleMapper;
import com.mlw.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author mlw
 * @create 2018-03-13 下午4:44
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public Set<String> findRoleByUserId(String id) {
        return sysRoleMapper.findRoleByUserId(id);
    }

}
