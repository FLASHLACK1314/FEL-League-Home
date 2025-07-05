package com.flashlack.felleaguehome.service.mail;

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
     * @param email 接收验证码的邮箱地址
     */
    void checkCodeExpireTime(String email);
}
