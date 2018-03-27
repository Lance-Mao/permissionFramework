package com.mlw.mapper;

import com.mlw.entity.SysUserRole;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);


    SysUserRole selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}