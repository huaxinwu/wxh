/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 线程局部
 * 字符串不适合代替能力表
 * 设计一个线程局部变量
 * @author wxh
 * @version $Id: ThreadLocal.java, v 0.1 2017年9月18日 下午1:37:40 wxh Exp $
 */
public class ThreadLocal {

    /**
     * 强制私有化，防止被实例化
     */
    private ThreadLocal() {

    }

    /**
     * 静态内部类
     */
    public static class Key {
        Key() {

        }
    }

    /**
     * 唯一，不可伪造
     *
     * @return
     */
    public static Key getKey() {
        return new Key();
    }

    public static void set(Key key, Object value) {

    }

    public static Object get(Key key) {
        return null;
    }

    public static void set(Object value) {

    }

    public static Object get() {
        return null;
    }

    /**
     * 这种设计，当多个用户调用set和get方法时候，会导致获取失败
     * 修正这个问题:1.只要使用一个不可伪造的键，有时候也称能力;2.将值作为key实例进行处理
     * 设置key对应value
     * @param key 键
     * @param value 值
     */
    public static void set(String key, Object value) {

    }

    /**
     * 根据key获取value
     * @param key 键
     * @return Object 对象
     */
    public static Object get(String key) {
        return null;
    }
}
