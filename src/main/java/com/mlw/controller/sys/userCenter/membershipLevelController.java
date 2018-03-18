package com.mlw.controller.sys.userCenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mlw
 * @create 2018-03-18 下午12:36
 */
@Controller
@RequestMapping("views")
public class membershipLevelController {

    @RequestMapping("user/userGrade")
    public String index() {
        return "user/userGrade";
    }
}
