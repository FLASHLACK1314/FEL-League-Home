package com.flashlack.felleaguehome.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户数据对象（UserDO）类。
 * @author FLASHLACK
 */
@Data
@Accessors(chain = true)
public class UserDO {
    // 用户唯一标识符
    private String userUuid;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 电子邮件地址
    private String email;
    // QQ号
    private String qqAccount;
    // 角色唯一标识符
    private String roleUuid;
}
