package com.mlw.controller.sys.authorityManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色管理
 * @author mlw
 * @create 2018-03-18 下午3:18
 */
@Controller
@RequestMapping("permissionOperation")
public class RoleManagementController {

    @RequestMapping("/roleManagement")
    public String index() {
        return "permissionOperation/roleManagement";
    }
}
