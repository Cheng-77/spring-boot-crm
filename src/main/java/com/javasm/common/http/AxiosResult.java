package com.javasm.common.http;

import lombok.Data;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-10:07
 * @Since：jdk1.8
 * @Description：
 */
@Data
public class AxiosResult<T> {
    private int status;

    private String message;

    private T data;

    private AxiosResult(EnumStatus enumStatus, T data) {
        this.status = enumStatus.getStatus();
        this.message = enumStatus.getMessage();
        this.data = data;
    }

    private static <T> AxiosResult getAxiosResult(EnumStatus enumStatus,T data){
        return new AxiosResult(enumStatus,data);
    }

    public static <T> AxiosResult<T> success(T data){
        return getAxiosResult(EnumStatus.SUCCESS,data);
    }

    public static <T> AxiosResult<T> success(){
        return getAxiosResult(EnumStatus.SUCCESS,null);
    }

    public static <T> AxiosResult<T> error(T data){
        return getAxiosResult(EnumStatus.ERROR,data);
    }
    public static <T> AxiosResult<T> error(){
        return getAxiosResult(EnumStatus.ERROR,null);
    }




}
