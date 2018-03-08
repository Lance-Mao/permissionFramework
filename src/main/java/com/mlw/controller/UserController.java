package com.mlw.controller;

import com.mlw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> test() {
        System.out.println(123);
        try {
            System.out.println("try-catch");
            System.out.println(userService.getUserAll());
            return userService.getUserAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/toLogin")
    public String login() {
        return "login/login";
    }
}