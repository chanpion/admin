package com.chanpion.admin.system.controller;

import com.chanpion.admin.system.entity.User;
import com.chanpion.admin.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/31 15:14
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping
    public String user() {
        return "system/user";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> allUser() {
        return userService.findAll();
    }
}
