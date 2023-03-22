package com.javasm.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.javasm.domain.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* 
* @author 追梦
* @since 2023-03-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "base_brand")
public class Brand extends BaseEntity {

    /**
    * 品牌名称
    */
    private String brandName;

    /**
    * 品牌描述
    */
    private String brandDesc;

    /**
    * 品牌LOGO
    */
    private String brandLogo;

    /**
    * 品牌官网
    */
    private String brandSite;



}

