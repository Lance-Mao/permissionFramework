package com.mlw.controller.sys.systemSettings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mlw
 * @create 2018-03-18 下午12:41
 */
@Controller
@RequestMapping("views")
public class BasicParameterController {

    @RequestMapping("systemSetting/basicParameter")
    public String index() {
        return "systemSetting/basicParameter";
    }
}
