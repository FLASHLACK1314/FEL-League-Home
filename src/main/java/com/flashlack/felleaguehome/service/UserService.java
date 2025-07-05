package com.flashlack.felleaguehome.service;

import com.flashlack.felleaguehome.constant.StringConstant;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * 用户服务接口（UserService）定义了与用户相关的业务逻辑方法。
 * @author FLASHLACK
 */
public interface UserService {
    /**
     * 检查用户名是否有效。
     * @param username 用户名
     */
    void checkUserName(
            @NotNull(message = "用户名不能为空")
            @Pattern(regexp = StringConstant.Regular.USER_NAME_REGULAR_EXPRESSION,
                    message = "用户名格式不正确")
            String username);

    /**
     * 检查电子邮件是否有效。
     * @param email 电子邮件地址
     */
    void checkEmail(
            @NotNull(message = "电子邮件不能为空")
            @Pattern(regexp = StringConstant.Regular.EMAIL_REGULAR_EXPRESSION,
            message = "电子邮件格式不正确")
                    String email);

    /**
     * 检查QQ号是否有效。
     * @param qq QQ号
     */
    void checkQa(
            @NotNull(message = "QQ号不能为空")
            @Pattern(regexp = StringConstant.Regular.QQ_REGULAR_EXPRESSION,
            message = "QQ号格式不正确")
            String qq);
}
