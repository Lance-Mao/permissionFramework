package com.mlw.mapper;

import com.mlw.entity.SysUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    Map<String,Object> getUserAll();

    List<SysUser> findSysUserByUsername(@Param("username") String username);
}