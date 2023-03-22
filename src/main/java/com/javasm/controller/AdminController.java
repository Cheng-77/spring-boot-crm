package com.javasm.controller;


import com.javasm.common.http.AxiosResult;
import com.javasm.common.http.PageResult;
import com.javasm.domain.entity.Admin;
import com.javasm.service.IAdminService;
import com.javasm.domain.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author 追梦
 */
@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {


    private final IAdminService adminService;


    @GetMapping("list")
    public AxiosResult<List<Admin>> selectList(){

        return AxiosResult.success(adminService.selectList());
    }

    @GetMapping("findById/{id}")
    public AxiosResult<Admin> findById(@PathVariable Integer id){

        return AxiosResult.success(adminService.findById(id));
    }

    @PutMapping("updateById")
    public AxiosResult<Integer> updateById(@RequestBody Admin admin){

        return AxiosResult.success(adminService.updateById(admin));
    }

    @PostMapping("insert")
    public AxiosResult<Integer> insert(@RequestBody Admin admin){

        return AxiosResult.success(adminService.insert(admin));
    }

    @DeleteMapping ("deleteById/{id}")
    public AxiosResult<Integer> deleteById(@PathVariable Integer id){

        return AxiosResult.success(adminService.deleteById(id));
    }


    @DeleteMapping ("deleteBatchById/{idList}")
    public AxiosResult<Integer> deleteBatchById(@PathVariable List<Serializable> idList){
        return AxiosResult.success(adminService.bathDeleteByIdList(idList));
    }

    @DeleteMapping ("deleteBatchById")
    public AxiosResult<Integer> deleteBatchByIdList(@RequestParam List<Serializable> idList){
        return AxiosResult.success(adminService.bathDeleteByIdList(idList));
    }


    @GetMapping("findByPage")
    public AxiosResult<PageResult<AdminVo>> findByPage(@RequestParam(defaultValue = "1") Integer currentPage,@RequestParam(defaultValue = "2") Integer pageSize){


        PageResult<AdminVo> adminVoPageResult =  adminService.findByPage(currentPage,pageSize);


        // total  adminVoList currentPage pageSize
        return AxiosResult.success(adminVoPageResult);

    }




}

