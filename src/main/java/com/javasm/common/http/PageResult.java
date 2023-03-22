package com.javasm.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResult <T>{
    private Long total;
    private List<T> dataList;

    private Integer currentPage;

    private Integer pageSize;

}
