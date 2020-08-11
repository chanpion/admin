package com.chanpion.admin.system.service;

import com.chanpion.admin.system.entity.User;

/**
 * @author April Chen
 * @date 2020/7/31 15:14
 */
public interface UserService extends BaseService<User> {

    /**
     * 根据名字查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findByName(String username);
}
