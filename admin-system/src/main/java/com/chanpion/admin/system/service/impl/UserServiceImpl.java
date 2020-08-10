package com.chanpion.admin.system.service.impl;

import com.chanpion.admin.common.utils.LogUtil;
import com.chanpion.admin.system.dao.UserDAO;
import com.chanpion.admin.system.entity.User;
import com.chanpion.admin.system.service.UserService;
import com.chanpion.admin.system.utils.ShiroUtil;
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
        return userDAO.findAll();
    }

    @Override
    public void add(User user) {
        String salt = ShiroUtil.randomSalt();
        user.setSalt(salt);
        String password = ShiroUtil.encryptPassword(user.getPassword(), salt);
        user.setPassword(password);
        userDAO.insert(user);
    }

    @Override
    public void update(User item) {
        int row = userDAO.update(item);
        LogUtil.info("update:{}", row);
    }

    @Override
    public void remove(User item) {
        int num = userDAO.delete(item);
        LogUtil.info("delete:{}", num);
    }

    @Override
    public List<User> find(User item) {
        return null;
    }
}
