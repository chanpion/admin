package com.chanpion.admin.system.model;

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
    private int order;

    private List<Menu> children;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }
}
