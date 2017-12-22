/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 *  一个模拟：circle of sequence
 *  圆的序列
 *  浮点运算
 * @author wxh
 * @version $Id: SequenceCircle.java, v 0.1 2017年12月21日 下午2:42:34 wxh Exp $
 */
public class SequenceCircle {

    /**
     * 永久序列
     */
    static void sequenceItForever() {
        float f = 2;
        for (;;) {
            f *= f;
            f = 0 - f;
        }
    }

}
