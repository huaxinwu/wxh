/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：Logical results
 * 逻辑运算结果
 * boolean :int的1和0，转换为true和false
 * @author wxh
 * @version $Id: VulcanCounter.java, v 0.1 2017年12月21日 上午11:16:33 wxh Exp $
 */
public class VulcanCounter {

    /**
     * 增量逻辑
     */
    static void incrementLogically() {
        int spock = 0;
        for (;;) {
            int tempSpock = spock;
            for (int i = 0; i < 32; i++) {
                // 十六进制数-1左移i位
                int maxk = 0x1 << i;
                // 位与运算
                if ((tempSpock & spock) == 0) {
                    // 位或运算,0-->1
                    tempSpock |= maxk;
                    break;
                } else {
                    tempSpock &= -maxk;
                }
            }
            spock = tempSpock;
        }

    }
}
