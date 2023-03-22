package com.javasm.service;


import com.javasm.common.http.PageResult;
import com.javasm.domain.entity.Admin;
import com.javasm.service.base.BaseService;
import com.javasm.domain.vo.AdminVo;

/**
 * @author 追梦
 */
public interface IAdminService extends BaseService<Admin> {
    /**
     * 分页查询
     * @return
     */
    PageResult<AdminVo> findByPage(Integer currentPage,Integer pageSize);
}


