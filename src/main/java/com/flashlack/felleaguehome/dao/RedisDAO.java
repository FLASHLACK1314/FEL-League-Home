package com.flashlack.felleaguehome.dao;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Redis 数据访问对象（RedisDAO）类。
 *
 * @author FLASHLACK
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class RedisDAO {
    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 保存邮箱验证码到 Redis 中。
     *
     * @param email 电子邮件地址
     * @param code  验证码
     */
    public void saveEmailCode(String email, String code) {
        // 设置过期时间为5分钟
        redisTemplate.opsForValue().set(email, code, 5 * 60);
        log.debug("保存邮箱验证码: {} -> {},\" 过期时间: 5分钟\"", email, code);
    }

    /**
     * 获取邮箱验证码。
     *
     * @param email 电子邮件地址
     * @return 验证码，如果不存在则返回 null
     */
    public String getEmailCode(String email) {
        String code = (String) redisTemplate.opsForValue().get(email);
        log.debug("获取邮箱验证码: {} -> {}", email, code);
        return code;
    }

    /**
     * 删除邮箱验证码。
     *
     * @param email 电子邮件地址
     */
    public void deleteEmailCode(String email) {
        redisTemplate.delete(email);
        log.debug("删除邮箱验证码: {}", email);
    }

}
