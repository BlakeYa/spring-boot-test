package org.example;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCacheTest {

    public static void main(String[] args) {

//        创建链接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1000); // 最大链接数
        poolConfig.setMaxIdle(100); // 最大空闲数
        poolConfig.setMinIdle(10); // 最小空闲数

        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379);


        try {
//        获取redis链接、
            Jedis jedis = jedisPool.getResource();
//            设置值
            jedis.set("key", "value");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//        获取redis缓存
        try (Jedis jedis = jedisPool.getResource()) {
            String value = jedis.get("key");
            if (value != null) {
                // 缓存命中
                System.out.println("缓存命中，从缓存中获取到key的值是：" + value);
            } else {
                // 缓存未命中，从数据库中获取数据
                System.out.println("缓存未命中，从数据库中获取数据");
            }
        }
    }

}
