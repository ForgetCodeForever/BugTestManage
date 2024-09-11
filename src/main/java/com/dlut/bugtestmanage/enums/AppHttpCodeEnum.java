package com.dlut.bugtestmanage.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"Success"),
    // 错误
    SYSTEM_ERROR(500,"Error"),
    // 用户管理 6xx
    // 用户注册模块
    USER_EXISTS(600,"User already exists"),
    USERNAME_NOT_NULL(601, "Username cannot be empty"),
    PASSWORD_NOT_NULL(602, "Password cannot be empty"),
    ROLETYPE_NOT_NULL(603, "Role type cannot be empty"),
    ROLETYPE_NOT_EXISTS(604, "用户角色类型不存在"),
    // 用户登录模块
    LOGIN_ERROR(601,"Invalid credentials"),
    // 用户退出模块
    USER_NOT_ONLINE(602, "User isn't online");

    int code;
    String msg;
    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
