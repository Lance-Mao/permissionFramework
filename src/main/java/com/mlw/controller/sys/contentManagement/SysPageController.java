package com.mlw.controller.sys.contentManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mlw
 * @create 2018-03-18 上午11:29
 */
@Controller
@RequestMapping("/views")
public class SysPageController {

    @RequestMapping("/news/newsList")
    public String index() {
        return "/news/newsList";
    }

}
