package com.javasm.service.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/16-17:17
 * @Since：jdk1.8
 * @Description：
 */
public interface BaseService <T> {
    //  常用的service里方法
    //查询一个 Long
    T findById(Serializable id);
    //查询所有
    List<T> selectList();
    //添加
    Integer insert(T entity);
    //修改
    Integer updateById(T entity);
    //删除

    Integer deleteById(Serializable id);
    //批量删除

    Integer bathDeleteByIdList( List<Serializable> idList);



}
