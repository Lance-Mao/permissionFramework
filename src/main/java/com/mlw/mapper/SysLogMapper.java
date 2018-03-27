package com.mlw.mapper;

import com.mlw.entity.SysLog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);
}