package com.chanpion.admin.system.entity;

import lombok.Data;

import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/28 8:14
 */
@Data
public class Menu {
    private Long id;
    private String name;
    private String url;
    private String icon;
    private int orderNumber;
    private Long pid;

    private List<Menu> children;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }
}
