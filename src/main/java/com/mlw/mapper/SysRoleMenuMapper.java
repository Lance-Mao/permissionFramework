package com.mlw.mapper;

import com.mlw.entity.SysRoleMenu;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}