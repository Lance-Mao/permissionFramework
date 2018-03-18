package com.mlw.controller.sys.systemSettings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mlw
 * @create 2018-03-18 下午12:42
 */
@Controller
@RequestMapping("views")
public class LinkListController {

    @RequestMapping("systemSetting/linkList")
    public String index() {
        return "systemSetting/linkList";
    }
}
