/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 糟糕的算术
 * 转换操作码
 * @author wxh
 * @version $Id: BadArithmetic.java, v 0.1 2017年12月20日 下午5:14:10 wxh Exp $
 */
public class BadArithmetic {

    /**
     * 两个数相加
     * @return
     */
    static byte addOneAndOne() {
        byte a = 1;
        byte b = 1;
        /**
         * byte c = a + b;编译出错，因为两个数之和压入栈的指令
         * 会将这个和的值转换为int类型值，因此两者不相等，编译不通过，
         * 所有必须强制转换成所要的类型
         */
        byte c = (byte) (a + b);

        return c;
    }

    /**
     * float类型转换为byte类型
     * @return
     */
    byte convertFloatToByte() {
        float a = 1f;
        /**
         * 这个强制转换在JVM进行两个步骤：
         * 1.float类型转换为int类型
         * 2.int类型转换为byte类型
         */
        byte b = (byte) a;

        return b;
    }

}
