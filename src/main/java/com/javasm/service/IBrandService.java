package com.javasm.service;


import com.javasm.common.http.PageResult;
import com.javasm.domain.criteria.BrandCriteria;
import com.javasm.domain.entity.Brand;
import com.javasm.domain.vo.BrandVo;
import com.javasm.service.base.BaseService;

/**
 * @author 追梦
 */
public interface IBrandService extends BaseService<Brand> {

    PageResult<BrandVo> findByPage(BrandCriteria brandCriteria);
}


