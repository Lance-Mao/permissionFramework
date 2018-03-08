package com.mlw.service.Impl;

import com.mlw.mapper.SysUserMapper;
import com.mlw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public Map<String, Object> getUserAll() {
        try {
            return sysUserMapper.getUserAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
