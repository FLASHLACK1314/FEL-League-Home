package com.flashlack.felleaguehome.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis 配置类，用于自定义 RedisTemplate 的序列化方式。
 * @author FLASHLACK
 */
@Configuration
public class RedisConfig {

    /**
     * 配置 RedisTemplate，使用 StringRedisSerializer 处理 Key，
     * 使用 Jackson2JsonRedisSerializer 处理 Value，以便于 JSON 序列化和反序列化。
     *
     * @param redisConnectionFactory Redis 连接工厂
     * @return 配置好的 RedisTemplate 实例
     */
    @Bean
    @SuppressWarnings("all") // 抑制所有警告，因为泛型擦除可能导致一些类型警告
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory); // 设置连接工厂

        // 配置 Key 的序列化器为 StringRedisSerializer
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer); // Hash 类型的 Key 也使用 String 序列化

        // 配置 Value 的序列化器为 Jackson2JsonRedisSerializer
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的范围，这里是所有字段，包括 private
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 推荐使用 activateDefaultTyping，并指定合适的 JsonTypeInfo.As
        // 确保在序列化和反序列化时能够处理多态类型
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);


        jackson2JsonRedisSerializer.setObjectMapper(om);

        template.setValueSerializer(jackson2JsonRedisSerializer); // 普通 Value 使用 JSON 序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer); // Hash 类型的 Value 也使用 JSON 序列化

        template.afterPropertiesSet(); // 初始化 Bean
        return template;
    }
}
