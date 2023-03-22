package com.javasm.controller;


import com.javasm.common.http.AxiosResult;
import com.javasm.common.http.PageResult;
import com.javasm.domain.criteria.BrandCriteria;
import com.javasm.domain.entity.Brand;
import com.javasm.domain.vo.BrandVo;
import com.javasm.service.IBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    
    @Resource
    private IBrandService brandService;
    
    @GetMapping("list")
    public AxiosResult<List<Brand>> selectList(){

        return AxiosResult.success(brandService.selectList());
    }

    @GetMapping("findById/{id}")
    public AxiosResult<Brand> findById(@PathVariable Integer id){

        return AxiosResult.success(brandService.findById(id));
    }

    @PutMapping("updateById")
    public AxiosResult<Integer> updateById(@RequestBody Brand brand){

        return AxiosResult.success(brandService.updateById(brand));
    }

    @PostMapping("insert")
    public AxiosResult<Integer> insert(@RequestBody Brand brand){

        return AxiosResult.success(brandService.insert(brand));
    }

    @DeleteMapping ("deleteById/{id}")
    public AxiosResult<Integer> deleteById(@PathVariable Integer id){

        return AxiosResult.success(brandService.deleteById(id));
    }


    @DeleteMapping ("deleteBatchById/{idList}")
    public AxiosResult<Integer> deleteBatchById(@PathVariable List<Serializable> idList){
        return AxiosResult.success(brandService.bathDeleteByIdList(idList));
    }

    @DeleteMapping ("deleteBatchById")
    public AxiosResult<Integer> deleteBatchByIdList(@RequestParam List<Serializable> idList){
        return AxiosResult.success(brandService.bathDeleteByIdList(idList));
    }

    @GetMapping("findByPage")  // BrandCriteria : key=value 参数
    public AxiosResult findByPage(BrandCriteria brandCriteria){



        PageResult<BrandVo> brandVoPageResult =  brandService.findByPage(brandCriteria);


        // total  brandVoList currentPage pageSize
        return AxiosResult.success(brandVoPageResult);
    }


}

