package com.javasm.transfer.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * entity和vo之间的转换
 */
@Slf4j
public class BaseTransfer<T, VO> {

    private Class<T> clazzT;
    private Class<VO> clazzVO;

    public BaseTransfer() {
        Type types = this.getClass().getGenericSuperclass();
        Type[] genericType = ((ParameterizedType) types).getActualTypeArguments();
        clazzT = (Class<T>) genericType[0];
        clazzVO = (Class<VO>) genericType[1];
    }

    /**
     * 转VO
     */
    public VO toVO(T t) {
        try {
            VO vo = clazzVO.newInstance();
            //spring内置的工具类 转换entity 和vo  BeanUtils.copyProperties(t, vo);
            BeanUtils.copyProperties(t, vo);
            return vo;
        } catch (Exception e) {
            log.error("toVO转换错误", t);
        }
        return null;

    }


    /**
     * 转T
     */

    public T toEntity(VO vo) {
        try {
            T t = clazzT.newInstance();
            BeanUtils.copyProperties(vo, t);
            return t;
        } catch (Exception e) {
            log.error("toEntity转换错误", vo);
        }
        return null;
    }

    /**
     * 转VO
     */
    public List<VO> toVO(List<T> list) {
        List<VO> list1 = new ArrayList<>();
        list.forEach(t -> list1.add(toVO(t)));
        return list1;
    }

    /**
     * 转Entity
     */
    public List<T> toEntity(List<VO> list) {
        List<T> list1 = new ArrayList<>();
        list.forEach(vo -> list1.add(toEntity(vo)));
        return list1;
    }
}