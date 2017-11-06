/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 非线程安全的数值序列生成器
 * @author wxh
 * @version $Id: UnsafeSequence.java, v 0.1 2017年10月23日 下午4:17:53 wxh Exp $
 */
@NotThreadSafe
public class UnsafeSequence {

    private int value;

    /**
     * 返回一个唯一的数值
     * @return int
     */
    public int getNext() {
        // 多线程中禁止使用这个方式，引发线程不安全问题
        // 引发竞争资源
        return value++;
    }
}
