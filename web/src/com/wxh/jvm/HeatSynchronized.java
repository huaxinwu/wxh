/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * JVM同步机制：监视器
 * Java两种监视区域：同步语句(代码块)和同步方法
 * @author wxh
 * @version $Id: HeatSynchronized.java, v 0.1 2017年12月22日 下午3:25:28 wxh Exp $
 */
public class HeatSynchronized {

    private int[] intArray = new int[10];

    /**
     * 同步方法
     * 反转功能
     * Java虚拟机调用同步方法或从同步方法中返回没有使用任何特别的操作码。
     * 当虚拟机解析堆方法的符号引用，它判断这个方法是否是同步的。
     * 如果是同步的，虚拟机在调用方法之前获取一个锁。
     */
    synchronized void reverseOrder() {
        int halfWay = intArray.length / 2;
        for (int i = 0; i < halfWay; i++) {
            int upperIndex = intArray.length - 1 - i;
            // 交换位置
            int save = intArray[upperIndex];
            intArray[upperIndex] = intArray[i];
            intArray[i] = save;
        }
    }

}
