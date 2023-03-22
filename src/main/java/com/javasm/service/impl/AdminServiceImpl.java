package com.javasm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.common.http.PageResult;
import com.javasm.domain.entity.Admin;
import com.javasm.mapper.AdminMapper;
import com.javasm.service.IAdminService;
import com.javasm.service.impl.base.BaseServiceImpl;
import com.javasm.transfer.AdminTransfer;
import com.javasm.domain.vo.AdminVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 追梦
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminTransfer adminTransfer;
    @Override
    public PageResult<AdminVo> findByPage(Integer currentPage,Integer pageSize) {


        PageHelper.startPage(currentPage,pageSize);
        List<Admin> adminList = adminMapper.selectList(null);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(adminList);

        long total = adminPageInfo.getTotal();

        List<AdminVo> adminVoList = adminTransfer.setSexAndDeptName(adminList);

        //需要把adminList转成 adminVoList
//        BeanUtils.copyProperties(admin,adminVo);
        PageResult<AdminVo> adminVoPageResult = new PageResult<>();

        adminVoPageResult.setTotal(total);
        adminVoPageResult.setDataList(adminVoList);

        return adminVoPageResult;
    }
}


