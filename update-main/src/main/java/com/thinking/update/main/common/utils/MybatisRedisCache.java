package com.thinking.update.main.common.utils;


import com.thinking.update.main.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hanlizhi
 * @create 2017-10-25 14:34
 */
@Slf4j
public class MybatisRedisCache implements Cache {

    @Autowired
    private RedisConfig redisConfig;

    private Jedis redisClient;

    /** The ReadWriteLock. */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;
    //用于读取配置文件
    public MybatisRedisCache(final String id) throws IOException {
        JedisPool pool = new JedisPool(new JedisPoolConfig(),redisConfig.getRedis().get("host"));
        redisClient = pool.getResource();
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        return Integer.valueOf(redisClient.dbSize().toString());
    }

    @Override
    public void putObject(Object key, Object value) {
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
    }

    @Override
    public Object getObject(Object key) {
        Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"="+value);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()),0);
    }

    @Override
    public void clear() {
        redisClient.flushDB();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
