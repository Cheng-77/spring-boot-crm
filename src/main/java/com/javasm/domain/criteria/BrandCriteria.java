package com.javasm.domain.criteria;

import com.javasm.domain.criteria.base.BaseCriteria;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-17:17
 * @Since：jdk1.8
 * @Description：
 */

@Data
public class BrandCriteria extends BaseCriteria {

    /**
     * 品牌名称
     */
    private String brandName;


}
