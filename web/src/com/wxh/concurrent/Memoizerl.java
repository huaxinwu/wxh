/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用hashmap和同步机制来初始化缓存
 * @author wxh
 * @version $Id: Memoizerl.java, v 0.1 2017年10月30日 下午2:20:33 wxh Exp $
 */
public class Memoizerl<K, V> implements Computable<K, V> {

    private final Map<K, V>        cache = new HashMap<K, V>();
    private final Computable<K, V> c;

    public Memoizerl(Computable<K, V> c) {
        this.c = c;
    }

    /** 
     * @param arg
     * @return
     * @throws InterruptedException
     * @see com.wxh.concurrent.Computable#compute(java.lang.Object)
     */
    @Override
    public synchronized V compute(K arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            // 缓存中存在计算的值直接返回，没有通过计算后把值存入缓存再返回
            result = c.compute(arg);
            cache.put(arg, result);

        }
        return result;
    }

}
