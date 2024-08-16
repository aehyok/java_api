package com.sun.xxm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import static cn.hutool.core.util.ObjectUtil.deserialize;
import static cn.hutool.core.util.ObjectUtil.serialize;

@Component
@Service
public class RedisService<T> {

    private final JedisPool jedisPool;

    @Autowired
    public RedisService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    /**
     * 向Redis中存值，永久有效
     */
    public void set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
    }

    /**
     * 可通过timeout设置过期时间（单位秒）
     * @param key 键
     * @param value 值
     * @param timeout 过期时间
     */
    public void set(String key, String value, long timeout) {
        try (Jedis jedis = jedisPool.getResource()) {
            SetParams params = new SetParams().ex(timeout);
            jedis.set(key,value, params);
        }
    }

    /**
     * 根据key获取value
     * @param key
     */
    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }

    /**
     * 根据key删除对应的缓存
     * @param key
     */
    public void delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(key);
        }
    }

    // 泛型操作
    public <T extends Serializable> void set(String key, T value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key.getBytes(), serialize(value));
        }
    }

    public <T extends Serializable> T get(String key, Class<T> type) {
        try (Jedis jedis = jedisPool.getResource()) {
            byte[] bytes = jedis.get(key.getBytes());
            return (bytes != null) ? deserialize(bytes, type) : null;
        }
    }
}
