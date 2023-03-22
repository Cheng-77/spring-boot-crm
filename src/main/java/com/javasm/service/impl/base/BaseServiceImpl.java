package com.javasm.service.impl.base;

import com.javasm.mapper.base.MyMapper;
import com.javasm.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/16-17:32
 * @Since：jdk1.8
 * @Description：
 */
//@Service
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired   //@Resource  会报绑定不上异常，要用     @Autowired
    private MyMapper<T> myMapper;

    public MyMapper<T> getMyMapper() {
        return myMapper;
    }

    public void setMyMapper(MyMapper<T> myMapper) {
        this.myMapper = myMapper;
    }

    @Override
    public T findById(Serializable id) {
        return myMapper.selectById(id);
    }

    @Override
    public List<T> selectList() {
        return myMapper.selectList(null);
    }

    @Override
    public Integer insert(T entity) {
        return myMapper.insert(entity);
    }

    @Override
    public Integer updateById(T entity) {
        return myMapper.updateById(entity);
    }

    @Override
    public Integer deleteById(Serializable id) {
        return myMapper.deleteById(id);
    }

    @Transactional
    @Override
    public Integer bathDeleteByIdList(List<Serializable> idList) {
        return myMapper.deleteBatchIds(idList);
    }
}
