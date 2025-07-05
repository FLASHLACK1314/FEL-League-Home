package com.flashlack.felleaguehome.common;

import lombok.Getter;

/**
 * 错误码枚举类（ErrorCodeEnum）用于定义系统中的各种错误码和对应的消息。
 *
 * @author FLASHLACK
 */
@Getter
public enum ErrorCodeEnum {
    // 通用成功
    SUCCESS(0, "操作成功"),

    // 通用业务失败
    COMMON_BUSINESS_ERROR(1000, "业务处理失败"),

    // 用户相关错误 (1001 - 1999)
    USER_NOT_FOUND(1001, "用户不存在"),
    PASSWORD_MISMATCH(1002, "密码错误"),
    USER_ALREADY_EXISTS(1003, "用户名已存在"),
    EMAIL_ALREADY_REGISTERED(1004, "邮箱已被注册"),
    ROLE_NOT_FOUND(1005, "角色不存在"),
    DATA_BASE_NOT_FOUND(1999, "数据库数据未找到"),

    // 参数校验错误 (2000 - 2999)
    INVALID_PARAMETER(2000, "参数校验失败"),

    // 认证/授权错误 (3000 - 3999)
    UNAUTHORIZED(3000, "未授权访问"),
    FORBIDDEN(3001, "无权限操作"),

    // 服务器内部错误 (5000 - 5999)
    INTERNAL_SERVER_ERROR(5000, "服务器内部错误，请稍后再试");


    private final Integer code;
    private final String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}


