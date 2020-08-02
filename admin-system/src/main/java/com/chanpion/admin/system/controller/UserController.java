package com.chanpion.admin.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author April Chen
 * @date 2020/7/31 15:14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String user() {
        return "system/user";
    }
}
