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

    List<Menu> findByPid(long pid);
}
