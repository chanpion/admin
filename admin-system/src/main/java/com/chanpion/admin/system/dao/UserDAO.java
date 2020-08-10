package com.chanpion.admin.system.dao;

import com.chanpion.admin.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author April Chen
 * @date 2020/7/31 15:10
 */
@Repository
@Mapper
public interface UserDAO extends BaseDAO<User> {

    User findByName(String username);
}
