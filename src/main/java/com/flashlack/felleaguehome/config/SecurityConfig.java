package com.flashlack.felleaguehome.config;


import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 安全配置类（SecurityConfig）用于配置应用程序的安全设置。
 * @author FLSHLACK
 */
@Slf4j
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(@NotNull HttpSecurity security) throws Exception {
        log.info("[INIT] SpringSecurity 配置初始化");
        return security
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                // 禁用 Spring Security 的自带授权验证
                .formLogin(AbstractHttpConfigurer::disable)
                //.addFilterBefore(new RequestHeaderFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/**")
                                .permitAll()
                                .anyRequest()
                                .permitAll()
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        log.info("[INIT] PasswordEncoder Bean 初始化");
        return new BCryptPasswordEncoder();
    }
}
