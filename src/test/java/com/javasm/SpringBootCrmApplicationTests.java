package com.javasm;

import com.javasm.domain.entity.Admin;
import com.javasm.mapper.AdminMapper;
import com.javasm.transfer.AdminTransfer;
import com.javasm.domain.vo.AdminVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringBootCrmApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {

        Admin admin = adminMapper.selectById(14);
        AdminVo adminVo = new AdminVo();

        BeanUtils.copyProperties(admin,adminVo);

        log.info("admin====="+admin.toString());
        log.info("adminVo====="+adminVo.toString());





    }

    @Test
    void contextLoads1() {

        List<Admin> adminList = adminMapper.selectList(null);

        ArrayList<AdminVo> adminVoList = new ArrayList<AdminVo>(adminList.size());


        for (int i = 0; i < adminList.size(); i++) {
            Admin admin = adminList.get(i);

            AdminVo adminVo = new AdminVo();

            BeanUtils.copyProperties(admin,adminVo);

            adminVoList.add(adminVo);

        }



        for (int i = 0; i < adminVoList.size(); i++) {

            log.info("admin====="+adminList.get(i).toString());
            log.info("adminVo====="+adminVoList.get(i).toString());

        }


        for (int i = 0; i < adminVoList.size(); i++) {
            AdminVo adminVo = adminVoList.get(i);
            Admin admin = adminList.get(i);
            Integer gender = admin.getGender();
            if (gender == 0){
                adminVo.setSex("男");
            }else if (gender == 1){
                adminVo.setSex("女");
            }else {
                adminVo.setSex("未知");
            }


        }

        for (int i = 0; i < adminVoList.size(); i++) {
            log.info("adminVo====="+adminVoList.get(i).toString());
        }

    }
    @Autowired
    private AdminTransfer adminTransfer;
    @Test
    public void testTransfer(){
        Admin admin = adminMapper.selectById(14);
        AdminVo adminVo = adminTransfer.toVO(admin);


        log.info("admin==="+admin.toString());
        log.info("adminVo==="+adminVo.toString());
    }

    @Test
    public void testTransferList(){
        List<Admin> adminList = adminMapper.selectList(null);

        List<AdminVo> adminVoList = adminTransfer.toVO(adminList);
        for (int i = 0; i < adminVoList.size(); i++) {
            log.info("admin==="+ adminList.get(i).toString());
            log.info("adminVo==="+adminVoList.get(i).toString());
        }

    }

}
