package com.mlw.mapper;

import com.mlw.entity.SysRole;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    Set<String> findRoleByUserId(String id);
}