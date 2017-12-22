/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：conversion diversion
 * 类型转换
 * @author wxh
 * @version $Id: Diversion.java, v 0.1 2017年12月21日 上午9:58:55 wxh Exp $
 */
public class Diversion {

    /**
     *  转换
     */
    static void convert() {
        byte imByte = 0;
        int imInt = 125;
        // 死循环
        for (;;) {
            ++imInt;
            imByte = (byte) imInt;
            imInt *= -1;

            imByte = (byte) imInt;
            imInt *= -1;
        }
    }

}
