package com.chanpion.admin.system.service.impl;

import com.chanpion.admin.system.dao.UserDAO;
import com.chanpion.admin.system.entity.User;
import com.chanpion.admin.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/31 15:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void add(User item) {

    }

    @Override
    public void update(User item) {

    }

    @Override
    public void remove(User item) {

    }

    @Override
    public List<User> find(User item) {
        return null;
    }
}
