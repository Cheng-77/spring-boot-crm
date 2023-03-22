package com.javasm.domain.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-9:44
 * @Since：jdk1.8
 * @Description：
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity implements Serializable {

    /**
     * 管理员id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 创建者
     */
    @JsonIgnore
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonIgnore
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    @JsonIgnore
    private Long updateBy;

    /**
     * 修改时间
     */
    @JsonIgnore
    private LocalDateTime updateTime;

}
