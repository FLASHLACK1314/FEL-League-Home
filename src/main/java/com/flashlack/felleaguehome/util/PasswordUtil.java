package com.flashlack.felleaguehome.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码工具类（PasswordUtil）提供了与密码相关的实用方法。
 *
 * @author FLASHLACK
 */
@Component
@RequiredArgsConstructor
public class PasswordUtil {
    private final PasswordEncoder passwordEncoder;

    /**
     * 对给定的密码进行加密。
     * @param password 明文密码
     * @return 加密后的密码
     */
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
    /**
     * 验证原始密码是否与哈希密码匹配。
     *
     * @param rawPassword 用户输入的明文密码
     * @param encodedPassword 数据库中存储的哈希密码
     * @return 如果匹配则返回 true，否则返回 false
     */
    public boolean matchesPassword(String rawPassword, String encodedPassword) {
        // 使用 PasswordEncoder 比较明文密码和哈希密码
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
