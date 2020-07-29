package com.chanpion.admin.controller;

import com.chanpion.admin.system.model.Menu;
import com.chanpion.admin.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/25 14:22
 */
@Controller
public class IndexController {

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        User user = new User();
        user.setUsername("April Chen");
        user.setImage("dist/img/user2-160x160.jpg");
        model.addAttribute("user", user);


        Menu menuTree = new Menu("菜单");

        Menu systemMenu = new Menu("系统管理");
        List<Menu> children = new ArrayList<>();
        children.add(new Menu("菜单管理"));
        children.add(new Menu("用户管理"));
        children.add(new Menu("权限管理"));
        systemMenu.setChildren(children);

        List<Menu> menus = new ArrayList<>();
        menus.add(systemMenu);
        menuTree.setChildren(menus);

        model.addAttribute("menus", menus);
        model.addAttribute("menuTree", menuTree);
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
}
