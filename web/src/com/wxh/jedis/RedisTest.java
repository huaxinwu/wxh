/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * jedis连接redis测试
 * @author wxh
 * @version $Id: RedisTest.java, v 0.1 2017年10月23日 上午10:42:39 wxh Exp $
 */
public class RedisTest {

    /** 客户端变量  */
    private Jedis jedis;

    @Before
    public void init() {
        // 连接redis服务器
        jedis = new Jedis("localhost", 6379);
        // 设置权限
        //        jedis.auth("admin");
    }

    /**
     * jedis操作字符串
     */
    @Test
    public void testString() {
        // 添加字符串
        jedis.set("name", "张三");
        System.out.println(jedis.get("name"));
        // 拼接字符串
        jedis.append("name", "是一个男人");
        System.out.println(jedis.get("name"));
        // 删除某个字符串
        jedis.del("name");
        System.out.println(jedis.get("name"));
        // 设置多个键值对
        jedis.mset("name", "xiaoming", "age", "16", "qq", "41524551");
        // 自增
        jedis.incr("age");
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }

    /**
     * jedis操作map
     */
    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<String, String>();
        // 添加数据
        map.put("name", "xiaohong");
        map.put("age", "18");
        map.put("qq", "12323234");

        // 将map存入redis
        jedis.hmset("user", map);

        // 获取一个List,第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变
        List<String> list = jedis.hmget("user", "name", "age", "qq");
        System.out.println(list);
        // 删除map中某个键值
        jedis.hdel("user", "age");
        System.out.println(jedis.hmget("user", "age"));
        // 返回key为user的键中存放的值的个数2
        System.out.println(jedis.hlen("user"));

        // 是否存在key为user的记录 返回true 
        System.out.println(jedis.hexists("user", "name"));

        // 返回map对象中的所有key 
        System.out.println(jedis.hkeys("user"));

        // 返回map对象中的所有value 
        System.out.println(jedis.hvals("user"));

        // 遍历map
        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + jedis.hget("user", key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList() {
        // 开始前，删除所有数据
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 向key为java framework添加三条数据,lpush在List头部添加数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有 (文件末尾)
        System.out.println(jedis.lrange("java framework", 0, -1));

        // 删除key为java framework的值
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // rpush在List尾部添加数据
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");

        System.out.println(jedis.lrange("java framework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet() {
        // 添加数据
        jedis.sadd("user", "aaa");
        jedis.sadd("user", "bbb");
        jedis.sadd("user", "ccc");
        jedis.sadd("user", "ddd");
        jedis.sadd("user", "who");
        // 删除某个key对于的值
        jedis.srem("user", "who");
        // 获取所有key对于value
        System.out.println(jedis.smembers("user"));

        // 判断 who是否是user集合的元素 
        System.out.println(jedis.sismember("user", "who"));

        // 返回user集合随机一个元素
        System.out.println(jedis.srandmember("user"));

        //返回集合的元素个数
        System.out.println(jedis.scard("user"));
    }

    /**
     * jedis操作ZSet
     */
    @Test
    public void testZSet() {
        //        jedis.flushDB();
        //        jedis.flushAll();
        // 添加数据
        Map<Double, String> map = new HashMap<Double, String>();
        map.put(1.0, "key1");
        map.put(2.0, "key2");
        map.put(3.0, "key3");
        map.put(4.0, "key4");
        map.put(5.0, "key5");

        jedis.zadd("zset", map);
        System.out.println(jedis.zrange("zset", 0, -1));
        // 删除某个key对于的值
        System.out.println(jedis.zrem("zset", "key5"));
        System.out.println(jedis.zrange("zset", 0, -1));

        // 获取某个key对应的值
        System.out.println(jedis.zscore("zset", "key3"));

        // 返回集合的个数
        System.out.println(jedis.zcard("zset"));
    }

    /**
     * jedis排序操作
     */
    @Test
    public void testSort() {
        // 注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的） 
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        // 排序前集合
        System.out.println(jedis.lrange("a", 0, -1));

        // 排序后集合
        System.out.println(jedis.sort("a"));

        // 排序前集合
        System.out.println(jedis.lrange("a", 0, -1));
    }

    /**
     * jedis连接池
     */
    @Test
    public void testRedisPool() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.set("jedispool", "jedis连接池");
        System.out.println(RedisUtil.getJedis().get("jedispool"));
    }
}
