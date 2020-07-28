package com.chanpion.admin.system.model;

import lombok.Data;

/**
 * @author April Chen
 * @date 2020/7/28 8:14
 */
@Data
public class Menu {
    private Long id;
    private String title;
    private String url;
    private String icon;
    private Long pid;
}
