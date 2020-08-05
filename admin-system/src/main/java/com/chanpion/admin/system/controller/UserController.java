package com.chanpion.admin.system.controller;

import com.chanpion.admin.common.BaseResponse;
import com.chanpion.admin.system.entity.User;
import com.chanpion.admin.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse addUser(User user) {
        userService.add(user);
        return BaseResponse.SUCCESS;
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public BaseResponse removeUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        userService.remove(user);
        return BaseResponse.SUCCESS;
    }

    @RequestMapping("/update")
    @ResponseBody
    public BaseResponse update(User user, Model model) {
        userService.update(user);
        return BaseResponse.SUCCESS;
    }
}