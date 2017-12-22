/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：斐波那契数列
 * @author wxh
 * @version $Id: Fibonacci.java, v 0.1 2017年12月20日 下午4:45:59 wxh Exp $
 */
public class Fibonacci {

    /**
     * 计算序列
     */
    static void calcSequence() {
        long fiboNum = 1;
        long a = 1;
        long b = 1;
        // 死循环
        for (;;) {
            fiboNum = a + b;
            a = b;
            b = fiboNum;
        }
    }

}
