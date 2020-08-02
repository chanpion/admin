package com.chanpion.admin.system.dao;

import com.chanpion.admin.system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/30 19:29
 */
@Repository
@Mapper
public interface MenuDAO extends BaseDAO<Menu> {

    /**
     * 根据父id查询所有子菜单
     *
     * @param pid 父菜单ID
     * @return 子菜单列表
     */
    List<Menu> findByPid(long pid);
}
