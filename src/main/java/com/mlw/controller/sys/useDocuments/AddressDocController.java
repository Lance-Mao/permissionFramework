package com.mlw.controller.sys.useDocuments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mlw
 * @create 2018-03-18 下午12:56
 */
@Controller
@RequestMapping("views")
public class AddressDocController {

    @RequestMapping("doc/addressDoc")
    public String index() {
        return "doc/addressDoc";
    }
}
