package com.mlw.controller.sys.userCenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户中心
 * @author mlw
 * @create 2018-03-18 下午12:34
 */

@Controller
@RequestMapping("views")
public class UserCenterController {

    @RequestMapping("user/userList")
    public String index() {
        return "user/userList";
    }
}
