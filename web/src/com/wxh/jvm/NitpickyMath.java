/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 异常的抛出与捕获
 * @author wxh
 * @version $Id: NitpickyMath.java, v 0.1 2017年12月21日 下午3:58:41 wxh Exp $
 */
public class NitpickyMath {

    /**
     * 两个数相加
     * @param a
     * @param b
     * @return
     * @throws OverflowException
     * @throws UndefflowException
     */
    static int add(int a, int b) throws OverflowException, UndefflowException {

        /**
         * 抛出异常:throws ...Exception
         * 捕获异常:try{...}catch(Exception e){...}或throw new ......Exception
         */
        long longA = (long) a;
        long longB = (long) b;
        long result = a + b;
        if (result > Integer.MAX_VALUE) {
            throw new OverflowException("向上溢出异常！");
        }
        if (result < Integer.MAX_VALUE) {
            throw new UndefflowException("向下溢出异常！");
        }
        return (int) result;
    }
}
