package com.javasm.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.javasm.domain.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* 
* @author 追梦
* @since 2023-03-17
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "base_dept")
public class Dept extends BaseEntity {




    /**
    * 部门名称
    */
    private String deptName;

    /**
    * 部门的上级部门id 如果是一级部门 则父id为0
    */
    private Long parentId;

    /**
    * 部门排序
    */
    private Integer deptSort;

    /**
    * 部门描述
    */
    private String deptDesc;


}

