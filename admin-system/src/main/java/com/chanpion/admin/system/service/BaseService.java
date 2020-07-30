package com.chanpion.admin.system.service;

import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/30 19:26
 */
public interface BaseService<T> {

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
    void add(T item);

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
    void remove(T item);

    /**
     * 查询列表
     *
     * @param item 条件
     * @return 列表
     */
    List<T> find(T item);
}
