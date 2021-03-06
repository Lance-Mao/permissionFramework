package com.mlw.controller.sys.authorityManagement;

import com.mlw.common.R;
import com.mlw.entity.SysMenu;
import com.mlw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 资源管理
 *
 * @author mlw
 * @create 2018-03-18 下午3:18
 */
@Controller
@RequestMapping("/permissionOperation")
public class ResourceManagementController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/resourceManagement")
    public String index() {
        return "permissionOperation/resourceManagement";
    }

    @RequestMapping("/getAllResource")
    @ResponseBody
    public List<SysMenu> getAllResource() {
        try {
            return permissionService.getAllResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") String id, Model model) {
        SysMenu sysMenu = permissionService.selectMenuById(id);
        model.addAttribute("menu", sysMenu);
        return "permissionOperation/resourceManagement_add";
    }

    @RequestMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") String menuId, Model model) {
        SysMenu sysMenu = permissionService.selectMenuById(menuId);
        model.addAttribute("menu", sysMenu);
        return "permissionOperation/resourceManagement_edit";
    }

    @RequestMapping("/del/{menuId}")
    @ResponseBody
    public R del(@PathVariable("menuId") String menuId, Model model) {
        if (permissionService.deleteMenuById(menuId) > 0) {
            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }

    @RequestMapping("/save")
    @ResponseBody
    public R save(SysMenu sysMenu) {
        if (permissionService.save(sysMenu) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @RequestMapping("/icon")
    public String icon() {
        return "/permissionOperation/icon";
    }
}
