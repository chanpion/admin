package com.chanpion.admin.system.entity;

import lombok.Data;

import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/28 8:14
 */
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

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
