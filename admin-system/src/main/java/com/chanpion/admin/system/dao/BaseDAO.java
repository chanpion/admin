package com.chanpion.admin.system.dao;

import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/30 19:16
 */
public interface BaseDAO<T> {

    /**
     * 全量查询
     *
     * @return 列表
     */
    List<T> findAll();

    /**
     * 插入数据
     *
     * @param item 数据记录
     */
    int insert(T item);

    /**
     * 更新数据
     *
     * @param item 数据记录
     */
    int update(T item);

    /**
     * 删除数据
     *
     * @param item 数据记录
     */
    int delete(T item);

    /**
     * 根据id删除数据
     *
     * @param id 数据库id
     * @return 删除条数
     */
    int deleteById(Long id);

    /**
     * 查询列表
     *
     * @param item 条件
     * @return 列表
     */
    List<T> find(T item);

    /**
     * 根据ID查询
     *
     * @param id 数据id
     * @return 数据记录
     */
    T findById(Long id);
}
