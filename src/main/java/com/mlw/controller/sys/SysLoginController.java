package com.mlw.controller.sys;

import com.mlw.common.R;
import com.mlw.entity.SysUser;
import com.mlw.service.PermissionService;
import com.mlw.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * @author mlw
 * @create 2018-03-08 上午11:34
 */

@Controller
public class SysLoginController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "sys/login", method = RequestMethod.POST)
    @ResponseBody
    public R login(String username, String password) {
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return R.error("账号或密码不正确");
        }catch (LockedAccountException e) {
            return R.error("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }

    @RequestMapping("getMenus")
    @ResponseBody
    public R getMenus() {
        try {
            SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
            Map<String, Object> menus = permissionService.getMenus(user.getId());

            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return R.error();
    }

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login/login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String index2() {
        return "index";
    }

    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }
}

