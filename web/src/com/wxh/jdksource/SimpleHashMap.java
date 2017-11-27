/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 简单hashmap
 * @author wxh
 * @version $Id: SimpleHashMap.java, v 0.1 2017年11月14日 下午4:23:11 wxh Exp $
 */
public class SimpleHashMap<K, V> {
    /** hashmap的元素个数 */
    private int                size;
    /** hashmap每次更新的次数 */
    private int                modCount;
    /** 默认初始化长度为16--1左移4位 */
    private static final int   DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /** 默认加载因子 */
    private static final float DEFAULT_LOAD_FACTOR      = 0.75f;
    /** 最大容量  */
    private static final int   MAXIMUM_CAPACITY         = 1 << 30;
    /** 加载因子 */
    private float              loadFactor;
    private int                threshold;

    public void init() {

    }

    public SimpleHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        threshold = initialCapacity;
        init();
    }

    public SimpleHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 获取hashmap的元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断hashmap是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public V get(Object key) {
        return null;
    }

    /**
     * 存入一个键值对
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        return null;
    }

}
