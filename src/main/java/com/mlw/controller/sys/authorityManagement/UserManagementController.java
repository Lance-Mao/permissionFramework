package com.mlw.controller.sys.authorityManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * @author mlw
 * @create 2018-03-18 下午3:19
 */
@Controller
@RequestMapping("permissionOperation")
public class UserManagementController {

    @RequestMapping("/userManagement")
    public String index() {
        return "permissionOperation/userManagement";
    }
}
