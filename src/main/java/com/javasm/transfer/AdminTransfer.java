package com.javasm.transfer;

import com.javasm.domain.entity.Admin;
import com.javasm.domain.entity.Dept;
import com.javasm.mapper.DeptMapper;
import com.javasm.transfer.base.BaseTransfer;
import com.javasm.domain.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-16:09
 * @Since：jdk1.8
 * @Description：
 */
@Component
public class AdminTransfer extends BaseTransfer<Admin, AdminVo> {

    @Autowired
    private DeptMapper deptMapper;
    public List<AdminVo> setSexAndDeptName(List<Admin> adminList) {

        List<AdminVo> adminVoList = super.toVO(adminList);

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

            Long deptId = admin.getDeptId();

            if (deptId != null){
                Dept dept = deptMapper.selectById(deptId);
                adminVo.setDeptName(dept.getDeptName());
            }

        }
        return adminVoList;
    }
}
