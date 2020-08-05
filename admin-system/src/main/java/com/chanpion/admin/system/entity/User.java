package com.chanpion.admin.system.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author April Chen
 * @date 2020/7/28 22:36
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String image;
    private Date createTime;
    private Integer age;
}
