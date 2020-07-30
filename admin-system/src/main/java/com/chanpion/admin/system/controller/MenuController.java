package com.chanpion.admin.system.controller;

import com.chanpion.admin.system.entity.Menu;
import com.chanpion.admin.system.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/28 8:14
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @GetMapping
    public String menu() {
        return "system/menu";
    }

    @GetMapping("/tree")
    public void tree() {
        List<Menu> menus = new ArrayList<>();
        List<Menu> children = new ArrayList<>();
        children.add(new Menu("菜单管理"));
        children.add(new Menu("用户管理"));
        children.add(new Menu("权限管理"));
        Menu menu = new Menu("系统管理");
        menu.setChildren(children);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Menu addMenu(Menu menu) {
        menuService.add(menu);
        return menu;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Menu> all() {
        return menuService.findAll();
    }
}
