package com.javasm.domain.vo;

import com.javasm.domain.vo.base.BaseVo;
import lombok.Data;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-17:14
 * @Since：jdk1.8
 * @Description：
 */
@Data
public class BrandVo extends BaseVo {
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
