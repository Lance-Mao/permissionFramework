package com.mlw.controller.sys;

import com.mlw.common.R;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;

/**
 * @author mlw
 * @create 2018-03-08 上午11:34
 */

@Controller
public class SysLoginController {

    @RequestMapping(value = "sys/login", method = RequestMethod.POST)
    @ResponseBody
    public R login(String username, String password) {
        try {
            Subject subject = null;
        } catch (UnknownAccountException e) {

        }
        return null;
    }
}
