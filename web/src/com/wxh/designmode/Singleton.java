/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 单利模式：确保一个类只有一个实例，并提供一个全局访问点。
 * 懒汉式
 * 懒汉式同步锁
 * 饿汉式
 * @author wxh
 * @version $Id: Singletom.java, v 0.1 2017年4月19日 上午11:32:36 wxh Exp $
 */
public class Singleton {

    private static Singleton          uniqueInstance;
    // 静态初始化器中创建单件
    private static Singleton          singleton = new Singleton();
    // 双重检查加锁
    private volatile static Singleton volSingle;

    /**
     * 单件模式的构造器必须私有化
     */
    private Singleton() {
    }

    /**
     * 1. 懒汉式同步锁按需加载---延迟实例化
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 2.饿汉式---急切实例化
     * @return
     */
    public static Singleton getInstance2() {
        return singleton;
    }

    /**
     * 双重检查加锁，检查实例是否存在，不存在加同步锁
     * 要求：jdk1.4以上
     * @return
     */
    public static Singleton getInstance3() {
        if (volSingle == null) {
            synchronized (Singleton.class) {
                if (volSingle == null) {
                    volSingle = new Singleton();
                }
            }
        }
        return volSingle;
    }
}
