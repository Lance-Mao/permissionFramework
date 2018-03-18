package com.mlw.controller.sys.contentManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 其他跳转页面的相关操作
 * @author mlw
 * @create 2018-03-18 下午12:19
 */
@Controller
@RequestMapping("views")
public class SysOtherController {

    @RequestMapping("/404")
    public String _404() {
        return "404";
    }

    @RequestMapping("/login/login")
    public String login() {
        return "login/login";
    }

}
