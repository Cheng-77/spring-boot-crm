package com.javasm.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2023/3/17-14:48
 * @Since：jdk1.8
 * @Description：
 */
@Data
public class AdminVo {

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 管理员昵称
     */
    private String nickName;

    /**
     * 管理员性别 0 : 男   1：女     2： 表示未知
     */
    private String sex; // 男   |  女  | 未知



    /**
     * 管理员性别 0 : 男   1：女     2： 表示未知
     */
    private Integer gender;
    /**
     * 管理员手机
     */
    private String adminPhone;

    /**
     * 管理员邮箱
     */
    private String adminEmail;

    /**
     * 管理员家住地址
     */
    private String adminAddress;

    /**
     * 管理员密码
     */
    private String adminPwd;

    /**
     * 管理员头像
     */
    private String adminAvatar;

    /**
     * 账户是否可用
     */
    private Boolean isEnable;

    /**
     * 是否是超级管理员
     */
    private Boolean isAdmin;

    /**
     * 所在部门
     */
    private String deptName;  // 部门名称


    /**
     * 重置密码时间
     */
    private LocalDateTime pwdResetTime;
}
