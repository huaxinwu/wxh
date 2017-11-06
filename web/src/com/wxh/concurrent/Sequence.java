/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 线程安全的数值序列生成器
 * @author wxh
 * @version $Id: Sequence.java, v 0.1 2017年10月23日 下午4:50:32 wxh Exp $
 */
@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }

}
