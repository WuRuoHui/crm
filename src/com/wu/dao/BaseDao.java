package com.wu.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDao接口
 * @param <T>
 */
public interface BaseDao<T> {
    void saveOrUpdate(T t);
    //保存
    void save(T t);
    //删除
    void delete(T t);
    //根据ID删除
    void delete(Serializable id);
    //更新
    void update(T t);
    //根据ID查询
    T getById(Serializable id);
    //查询符合条件的记录数
    Integer getTotalCount(DetachedCriteria dc);
    //根据离线查询对象查询list
    List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);
}