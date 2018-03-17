package com.mlw.common.dto;

import com.mlw.entity.SysMenu;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分层封装查询出来的信息
 * @author mlw
 * @create 2018-03-17 下午5:40
 */
public class SysMenuDto extends SysMenu {

    private List<SysMenuDto> lowerLevelMenu = new ArrayList<SysMenuDto>();

    public static SysMenuDto adapt(SysMenu sysMenu) {
        SysMenuDto sysMenuDto = new SysMenuDto();
        //通过反射将一个对象的值赋值个另外一个对象（前提是对象中属性的名字相同）
        BeanUtils.copyProperties(sysMenu, sysMenuDto);
        return sysMenuDto;
    }

    public List<SysMenuDto> getSysMenuDtoList() {
        return lowerLevelMenu;
    }

    public void setSysMenuDtoList(List<SysMenuDto> lowerLevelMenu) {
        this.lowerLevelMenu = lowerLevelMenu;
    }
}
