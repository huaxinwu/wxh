/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * JVM监视器支持两种线程：互斥和协作
 * JVM内置的同步机制就是监视器
 * Java两种监视区域：同步语句(代码块)和同步方法
 * @author wxh
 * @version $Id: KitchenSynchronized.java, v 0.1 2017年12月22日 下午3:07:30 wxh Exp $
 */
public class KitchenSynchronized {

    private int[] intArray = new int[10];

    /**
     * 同步语句
     * 反转功能
     */
    void reverseOrder() {
        // 单利模式中一般同步类
        // 如果没有获得当前对象锁，同步语句块内的代码是不会执行
        synchronized (this) {
            int halfWay = intArray.length;
            for (int i = 0; i < halfWay; i++) {
                int upperIndex = intArray.length - 1 - i;
                // 交换位置
                int save = intArray[upperIndex];
                intArray[upperIndex] = intArray[i];
                intArray[i] = save;
            }
        }
    }
}
