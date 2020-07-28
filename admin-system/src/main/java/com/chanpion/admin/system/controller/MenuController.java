package com.chanpion.admin.system.controller;

import com.chanpion.admin.system.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/28 8:14
 */
@Controller
@RequestMapping("/menu")
public class MenuController {


    @GetMapping("/tree")
    public void tree(){
        List<Menu> menus = new ArrayList<>();
        List<Menu> children = new ArrayList<>();
        children.add(new Menu("菜单管理"));
        children.add(new Menu("用户管理"));
        children.add(new Menu("权限管理"));
        Menu menu = new Menu("系统管理");
        menu.setChildren(children);
    }
}
