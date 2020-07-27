package com.chanpion.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author April Chen
 * @date 2020/7/25 14:22
 */
@Controller
public class IndexController {

    @GetMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/starter")
    public String start() {
        return "starter";
    }
}
