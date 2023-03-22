package com.javasm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.common.http.PageResult;
import com.javasm.domain.criteria.BrandCriteria;
import com.javasm.domain.entity.Brand;
import com.javasm.domain.entity.Brand;
import com.javasm.domain.vo.BrandVo;
import com.javasm.domain.vo.BrandVo;
import com.javasm.mapper.BrandMapper;
import com.javasm.service.IBrandService;
import com.javasm.service.impl.base.BaseServiceImpl;
import com.javasm.transfer.BrandTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 追梦
 */
@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand>implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandTransfer brandTransfer;

    @Override
    public PageResult<BrandVo> findByPage(BrandCriteria brandCriteria) {


        PageHelper.startPage(brandCriteria.getCurrentPage(),brandCriteria.getPageSize());

        //mp的条件查询
        LambdaQueryWrapper<Brand> brandLambdaQueryWrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(brandCriteria.getBrandName())){
                                            // brand_name
            brandLambdaQueryWrapper.likeRight(Brand::getBrandName,brandCriteria.getBrandName());
        }
        if (!StringUtils.isEmpty(brandCriteria.getStartTime())&& !StringUtils.isEmpty(brandCriteria.getEndTime())){
            brandLambdaQueryWrapper.between(Brand::getCreateTime,brandCriteria.getStartTime(),brandCriteria.getEndTime());
        }


        List<Brand> brandList = brandMapper.selectList(brandLambdaQueryWrapper);


        PageInfo<Brand> brandPageInfo = new PageInfo<>(brandList);

        long total = brandPageInfo.getTotal();

        List<BrandVo> brandVoList = brandTransfer.toVO(brandList);

        //需要把brandList转成 brandVoList
//        BeanUtils.copyProperties(brand,brandVo);
        PageResult<BrandVo> brandVoPageResult = new PageResult<>();

        brandVoPageResult.setTotal(total);
        brandVoPageResult.setDataList(brandVoList);

        return brandVoPageResult;
    }
}


