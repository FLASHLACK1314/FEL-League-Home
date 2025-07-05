package com.flashlack.felleaguehome.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 邮件配置类
 *
 * @author FLASHLACK
 */
@Configuration
public class MailConfig {
    @Resource
    private Environment env;

    /**
     * 邮件发送配置
     * <p>
     * 用于处理邮件的
     *
     * @return JavaMailSender 邮件发送对象
     */
    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl mail = new JavaMailSenderImpl();

        // 默认编码
        mail.setDefaultEncoding(env.getProperty("spring.mail.default-encoding", "UTF-8"));
        // 邮件服务器地址
        mail.setHost(env.getProperty("spring.mail.host"));
        // 邮件服务器端口
        mail.setPort(Integer.parseInt(env.getProperty("spring.mail.port", "25")));
        // 邮件服务器用户名
        String username = env.getProperty("spring.mail.username");
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("邮件服务器用户名不能为空");
        } else {
            mail.setUsername(username);
        }
        // 邮件服务器密码
        String password = env.getProperty("spring.mail.password");
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("邮件服务器密码不能为空");
        } else {
            mail.setPassword(password);
        }

        mail.setJavaMailProperties(new Properties() {{
            setProperty("mail.smtp.auth", "true");
            setProperty("mail.smtp.starttls.enable", "true");
            setProperty("mail.debug", "false");
            setProperty("mail.transport.protocol", "smtp");
        }});

        return mail;
    }
}
