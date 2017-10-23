/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis工具类(redis连接池)
 * @author wxh
 * @version $Id: RedisUtil.java, v 0.1 2017年10月23日 下午2:23:32 wxh Exp $
 */
public class RedisUtil {
    // redis服务器IP
    private static final String  HOST           = "localhost";
    // redis服务器端口
    private static final int     PORT           = 6379;

    // redis权限(密码)
    //    private static String auth = "admin";

    //可用连接实例的最大数目，默认值为8;
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static final int     MAX_ACTIVE     = 1024;

    // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static final int     MAX_IDLE       = 200;

    // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static final int     MAX_WAIT       = 10000;

    // 连接超时时间,单位毫秒
    private static final int     TIMEOUT        = 10000;

    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
    private static final boolean TEST_ON_BORROW = true;

    // 创建jedispool实例
    private static JedisPool     jedisPool      = null;

    /**
     * 初始化jedis连接池
     */
    static {
        try {
            // 配置jedispool相关属性(MaxActive/MaxIdle...)
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWait(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);

            // 实例化jedispool
            jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT);
        } catch (Exception e) {
            // 将日志打印到堆栈中
            e.printStackTrace();
        }
    }

    /**
     * 
     * 获取Jedis实例，必须加同步锁。防止线程的串化
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis jedis = jedisPool.getResource();
                return jedis;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void closeJedis(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}
