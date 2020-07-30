package com.chanpion.admin.system.dao;

import org.springframework.stereotype.Repository;

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
    void insert(T item);

    /**
     * 更新数据
     *
     * @param item 数据记录
     */
    void update(T item);

    /**
     * 删除数据
     *
     * @param item 数据记录
     */
    void delete(T item);

    /**
     * 查询列表
     *
     * @param item 条件
     * @return 列表
     */
    List<T> find(T item);
}
