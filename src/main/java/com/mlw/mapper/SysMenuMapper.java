package com.mlw.mapper;

import com.mlw.entity.SysMenu;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getMenus(String id);

    Set<String> findPermissionByUserId(String id);

    List<SysMenu> getAllResource();

    SysMenu selectMenuById(String id);
}