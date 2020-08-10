package com.chanpion.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author April Chen
 * @date 2020/7/25 14:22
 */
@Controller
public class IndexController {

    @GetMapping(value = {"", "/", "/index"})
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/starter")
    public String start() {
        return "starter";
    }

    @GetMapping("/table")
    public String table() {
        return "table";
    }

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
