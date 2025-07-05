package com.flashlack.felleaguehome.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置类（SecurityConfig）用于配置应用程序的安全设置。
 * @author FLSHLACK
 */
@Configuration
public class SecurityConfig {

    /**
     * 定义一个 PasswordEncoder Bean。
     * Spring Security 推荐使用 BCryptPasswordEncoder 进行密码哈希，因为它包含了加盐和自适应哈希功能。
     * @return BCryptPasswordEncoder 实例
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 默认工作因子是 10，你可以根据需要调整，数字越大计算越慢，安全性越高，但也会消耗更多CPU资源
        return new BCryptPasswordEncoder();
    }
}
