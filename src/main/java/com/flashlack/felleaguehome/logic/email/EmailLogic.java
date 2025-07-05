package com.flashlack.felleaguehome.logic.email;


import cn.hutool.core.util.RandomUtil;
import com.flashlack.felleaguehome.dao.RedisDAO;
import com.flashlack.felleaguehome.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 电子邮件逻辑处理类（EmailLogic）。
 *
 * @author FLASHLACK
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailLogic implements MailService {
    private final JavaMailSender javaMailSender;
    private final RedisDAO redis;
    private final Environment env;

    /**
     * 发送简单的电子邮件。
     *
     * @param to      收件人地址
     * @param subject 主题
     * @param text    邮件内容
     */

    private void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(env.getProperty("spring.mail.username"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            log.error("发送邮件失败: {}", e.getMessage());
            throw new RuntimeException("发送邮件失败", e);
        }
    }

    /**
     * 异步发送电子邮件验证码。
     *
     * @param to 收件人地址
     */
    @Override
    @Async
    public void sendEmailCode(String to) {
        log.debug("异步发送邮箱中");
        String code = RandomUtil.randomNumbers(6);
        // 发送邮件
        String subject = "FEL电子邮件验证码";
        String text = "您的验证码是: " + code + "，有效期为5分钟。请勿将此验证码泄露给他人。";
        this.sendSimpleEmail(to, subject, text);
        redis.saveEmailCode(to, code);
    }
}
