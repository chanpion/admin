package com.chanpion.admin.system.service.impl;

import com.chanpion.admin.system.dao.MenuDAO;
import com.chanpion.admin.system.entity.Menu;
import com.chanpion.admin.system.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/30 19:29
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDAO menuDAO;

    @Override
    public List<Menu> findAll() {
        return menuDAO.findAll();
    }

    @Override
    public void add(Menu item) {
        if (item == null) {
            return;
        }
        menuDAO.insert(item);
    }

    @Override
    public void update(Menu item) {

    }

    @Override
    public void remove(Menu item) {

    }

    @Override
    public List<Menu> find(Menu item) {
        return null;
    }
}
