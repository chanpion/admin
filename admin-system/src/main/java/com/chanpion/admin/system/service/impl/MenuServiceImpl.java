package com.chanpion.admin.system.service.impl;

import com.chanpion.admin.system.dao.MenuDAO;
import com.chanpion.admin.system.entity.Menu;
import com.chanpion.admin.system.service.MenuService;
import org.apache.commons.collections4.CollectionUtils;
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

    @Override
    public List<Menu> getMenuTree() {
        return getChildrenMenu(0L);
    }

    private List<Menu> getChildrenMenu(Long pid) {
        List<Menu> children = menuDAO.findByPid(pid);
        if (CollectionUtils.isNotEmpty(children)) {
            for (Menu m : children) {
                List<Menu> menuList = getChildrenMenu(m.getId());
                m.setChildren(menuList);
            }
        }
        return children;
    }
}
