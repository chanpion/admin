package com.chanpion.admin.system.service;

import com.chanpion.admin.system.entity.Menu;

import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/30 19:28
 */
public interface MenuService extends BaseService<Menu> {

    /**
     * 获取菜单树
     *
     * @return 系统菜单树
     */
    List<Menu> getMenuTree();
}
