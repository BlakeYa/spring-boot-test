package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 使用方式：
 * 1. 在需要使用的地方注入 RedisBloomFilter 对象。
 * 2. 调用 add() 方法将数据添加到布隆过滤器中。
 * 3. 调用 contains() 方法判断数据是否存在于布隆过滤器中和 Redis 中。
 *
 * 此代码可以有效的防止在 Redis 中缓存不存在的数据或大量重复查询同一无效数据的情况，同时减轻数据库或接口服务器的压力。
 */
@Slf4j
@Component
public class RedisBloomFilter {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    // 布隆过滤器容量，需要根据数据规模和错误率调整
    private int expectedInsertions = 1000000;

    // 错误率
    private double fpp = 0.001;

    // Redis Key 前缀
    private final String BLOOM_FILTER_SUFFIX = ":bloom-filter";

    private BloomFilter<String> bloomFilter;

    @PostConstruct
    public void init() {
        // 初始化布隆过滤器
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), expectedInsertions, fpp);

        // 加载 Redis 中已存在的数据
        Set<String> redisKeys = redisTemplate.keys("*" + BLOOM_FILTER_SUFFIX);
        for (String redisKey : redisKeys) {
            Set<String> values = redisTemplate.opsForSet().members(redisKey);
            bloomFilter.putAll(values);
        }
    }

    // 添加数据到布隆过滤器
    public void add(String key) {
        bloomFilter.put(key);
        String redisKey = getRedisKey(key);
        redisTemplate.opsForSet().add(redisKey, key);
    }

    // 判断是否存在于布隆过滤器
    public boolean contains(String key) {
        if (bloomFilter.mightContain(key)) {
            String redisKey = getRedisKey(key);
            Boolean exists = redisConnectionFactory.getConnection().setCommands().exists(redisKey.getBytes());
            return exists;
        }
        return false;
    }

    // 获取 Redis Key
    private String getRedisKey(String key) {
        return key + BLOOM_FILTER_SUFFIX;
    }

    // Redis 序列化方式
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}