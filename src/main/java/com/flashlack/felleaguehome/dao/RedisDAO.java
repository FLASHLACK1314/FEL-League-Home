package com.flashlack.felleaguehome.dao;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

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
        redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
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

    /**
     * 获取邮箱验证码的过期时间。
     *
     * @param key 键名
     * @return 过期时间（秒）
     */
    public long getEmailCodeExpireTime(String key) {
        // 获取键的过期时间，以秒为单位
        long expire = redisTemplate.getExpire(key);
        // 记录日志
        log.debug("键 {} 的过期时间为: {} 秒", key, expire);
        return expire;
    }

}
