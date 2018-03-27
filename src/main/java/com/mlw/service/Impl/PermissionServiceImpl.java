package com.mlw.service.Impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mlw.common.dto.SysMenuDto;
import com.mlw.entity.SysMenu;
import com.mlw.entity.SysUser;
import com.mlw.mapper.SysMenuMapper;
import com.mlw.mapper.SysUserMapper;
import com.mlw.service.PermissionService;
import com.mlw.util.LevelUtil;
import com.mlw.util.ShiroUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    public SysUser findSysUserByUsername(String username) {

        List<SysUser> list = sysUserMapper.findSysUserByUsername(username);

        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 对数据进行封装
     *
     * @param id
     * @return
     */
    public List<SysMenuDto> getMenus(String id) {

        //取出所有数据
        List<SysMenu> sysMenus = sysMenuMapper.getMenus(id);

        //对数据进行简单的封装
        List<SysMenuDto> dtoList = Lists.newArrayList();
        for (SysMenu sysMenu : sysMenus) {
            SysMenuDto sysMenuDto = SysMenuDto.adapt(sysMenu);
            dtoList.add(sysMenuDto);
        }

        return menuListToTree(dtoList);
    }

    /**
     * 处理第一层，也就分离顶级菜单
     *
     * @param dtoList
     * @return
     */
    private List<SysMenuDto> menuListToTree(List<SysMenuDto> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            new ArrayList<SysMenu>();
        }
        // level -> [dept1, dept2, ...] Map<String, List<Object>>
        Multimap<String, SysMenuDto> menuDtoMultimap = new ArrayListMultimap();
        List<SysMenuDto> topMenuDtos = Lists.newArrayList();

        for (SysMenuDto sysMenuDto : dtoList) {
            menuDtoMultimap.put(sysMenuDto.getPid(), sysMenuDto);
            if (LevelUtil.topNo.equals(sysMenuDto.getPid())) {
                topMenuDtos.add(sysMenuDto);
            }
        }
        Collections.sort(topMenuDtos, menuSort());

        transformDeptTree(topMenuDtos, menuDtoMultimap);
        return topMenuDtos;
    }

    /**
     * 处理每个当前层级下面的数据
     *
     * @param topMenuDtos
     * @param menuDtoMultimap
     */
    private void transformDeptTree(List<SysMenuDto> topMenuDtos, Multimap<String, SysMenuDto> menuDtoMultimap) {
        //读取上级菜单的元素
        for (int i = 0; i < topMenuDtos.size(); i++) {
            SysMenuDto sysMenuDto = topMenuDtos.get(i);
            //获取该层级元素的id,并进行匹配,将拥有相同父ID的菜单放在一起
            String pId = sysMenuDto.getId();
            List<SysMenuDto> lowerLevelMenu = (List<SysMenuDto>) menuDtoMultimap.get(pId);
            if (CollectionUtils.isNotEmpty(lowerLevelMenu)) {
                //对同级菜单进行排序
                Collections.sort(lowerLevelMenu, menuSort());
                //将该层级菜单放到对应的父层级下
                sysMenuDto.setSysMenuDtoList(lowerLevelMenu);
                //进入到下一层级进行处理
                transformDeptTree(lowerLevelMenu, menuDtoMultimap);
            }
        }
    }

    /**
     * 抽取排序方法
     *
     * @return
     */
    private Comparator<SysMenuDto> menuSort() {
        return new Comparator<SysMenuDto>() {
            public int compare(SysMenuDto t0, SysMenuDto t1) {
                return t0.getSort() - t1.getSort();
            }
        };
    }

    public Set<String> findPermissionByUserId(String id) {
        return sysMenuMapper.findPermissionByUserId(id);
    }

    public List<SysMenu> getAllResource() {

        List<SysMenu> sysMenus = sysMenuMapper.getAllResource();

        return sysMenuMapper.getAllResource();
    }

    public SysMenu selectMenuById(String id) {
        return sysMenuMapper.selectMenuById(id);
    }

    public int save(SysMenu sysMenu) {
        try {
            String id = sysMenu.getId();
            if (StringUtils.isEmpty(id)) {
                //获取当前系统操作者
                //如果当前菜单id不存在，则采用插入操作
                sysMenu.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                sysMenu.setCreateBy(ShiroUtils.getUserEntity().getName());
                return sysMenuMapper.insert(sysMenu);
            } else {
                //如果菜单Id存在，则进行更新
                sysMenu.setUpdateBy(ShiroUtils.getUserEntity().getName());
                return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteMenuById(String menuId) {
        return sysMenuMapper.deleteByPrimaryKey(menuId);
    }
}
