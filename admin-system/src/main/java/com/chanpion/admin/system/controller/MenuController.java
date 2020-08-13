package com.chanpion.admin.system.controller;

import com.chanpion.admin.system.MenuSearcher;
import com.chanpion.admin.system.entity.Menu;
import com.chanpion.admin.system.service.MenuService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
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

    @Resource
    private MenuSearcher menuSearcher;

    @GetMapping
    public String menu() {
        return "system/menu";
    }

    @GetMapping("/tree")
    @ResponseBody
    public Object tree() {
        return menuService.getMenuTree();
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

    @RequestMapping("/search/{name}")
    @ResponseBody
    public Object search(@PathVariable String name) throws Exception {
        return menuSearcher.search(name);
    }
}
