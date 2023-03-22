package com.javasm.domain.criteria.base;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-17:41
 * @Since：jdk1.8
 * @Description：
 */
@Data
public class BaseCriteria {
    private Integer currentPage =1;  // 当前页

    private Integer pageSize = 5;  // 每页大小

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;  // 开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime; // 结束时间
}
