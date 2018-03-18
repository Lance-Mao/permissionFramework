package com.mlw.controller.sys.useDocuments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mlw
 * @create 2018-03-18 下午12:57
 */
@Controller
@RequestMapping("views")
public class NavDocController {

    @RequestMapping("doc/navDoc")
    public String index() {
        return "doc/navDoc";
    }
}
