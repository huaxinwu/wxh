/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 线程安全的可变正整数
 * @author wxh
 * @version $Id: SynchronizedInteger.java, v 0.1 2017年10月24日 下午3:17:23 wxh Exp $
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue() {
        this.value = value;
    }

}
