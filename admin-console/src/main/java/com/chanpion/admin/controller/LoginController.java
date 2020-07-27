package com.chanpion.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author April Chen
 * @date 2020/7/27 17:24
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public void doLogin() {
        System.out.println("login...");
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public void doRegister() {
        System.out.println("register...");
    }

    @GetMapping("forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }
}
