/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 使用Java监听器模式线程安全计数器
 * @author wxh
 * @version $Id: Counter.java, v 0.1 2017年10月25日 下午2:18:52 wxh Exp $
 */
@ThreadSafe
public class Counter {

    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow.");
        }
        return ++value;
    }
}
