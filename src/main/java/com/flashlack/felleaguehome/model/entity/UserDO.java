package com.flashlack.felleaguehome.model.entity;

import lombok.Data;

/**
 * 用户数据对象（UserDO）类。
 * @author FLASHLACK
 */
@Data
public class UserDO {
    // 用户唯一标识符
    private String userUuid;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 电子邮件地址
    private String email;
    // QQ号
    private String qq;
    // 角色唯一标识符
    private String roleUuid;
}
