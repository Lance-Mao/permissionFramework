package com.mlw.controller.sys;

import com.mlw.common.R;
import com.mlw.common.ShiroUser;
import com.mlw.entity.SysMenu;
import com.mlw.service.PermissionService;
import com.mlw.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author mlw
 * @create 2018-03-16 下午5:17
 */
@Controller
@RequestMapping("/resource")
public class SysResourceController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/getMenus")
    @ResponseBody
    public R getMenus() {
        try {
            ShiroUser user = ShiroUtils.getUserEntity();
            List<SysMenu> menus = permissionService.getMenus(user.getId());
            return R.ok("menus",menus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return R.error();
    }
}
