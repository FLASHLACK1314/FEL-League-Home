package com.flashlack.felleaguehome.service.mail;

import com.flashlack.felleaguehome.constant.StringConstant;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * 邮件服务接口（MailService）用于处理邮件相关的操作。
 *
 * @author FLASHLACK
 */
public interface MailService {

    /**
     * 发送邮件方法(异步)
     *
     * @param to 收件人地址
     */
    void sendEmailCode(String to);

    /**
     * 检查验证码的过期时间。
     *
     * @param email 接收验证码的邮箱地址
     */
    void checkCodeExpireTime(String email);

    /**
     * 检查电子邮件验证码的有效性。
     * @param email 接收验证码的电子邮件地址
     * @param emailCode 电子邮件验证码
     */
    void checkEmailCode(
            @NotNull(message = "电子邮件不能为空")
            @Pattern(regexp = StringConstant.Regular.EMAIL_REGULAR_EXPRESSION,
                    message = "电子邮件格式不正确")
            String email,
            @NotNull(message = "邮箱验证码不能为空")
            @Pattern(
                    regexp = StringConstant.Regular.EMAIL_CODE_REGULAR_EXPRESSION,
                    message = "邮箱验证码格式不正确")
            String emailCode);
}
