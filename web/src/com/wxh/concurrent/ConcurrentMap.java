/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.Map;

/**
 *
 * @author wxh
 * @version $Id: ConcurrentMap.java, v 0.1 2017年10月30日 上午10:11:54 wxh Exp $
 */
public interface ConcurrentMap<K, V> extends Map<K, V> {

    /**
     * 仅当K没有映射值时才插入
     * @param key
     * @param valueV
     * @return
     */
    V putIfAbsent(K key, V valueV);

    /**
     * 仅当key映射到值才移除
     * @param key
     * @param valueV
     * @return
     */
    boolean remouve(K key, V value);

    /**
     * 仅当key被映射到oldValue，才替换
     * @param key
     * @param value
     * @return
     */
    boolean replace(K key, V oldValue, V newValue);

    /**
     * 仅当key映射到某个值，才替换
     * @param key
     * @param value
     * @return
     */
    V replace(K key, V value);
}
