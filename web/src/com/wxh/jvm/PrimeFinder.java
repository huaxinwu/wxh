/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：[Prime Time
 * 查找素数(除了能表示本身和1的乘积，不能再有其他表示方式的整数)
 * @author wxh
 * @version $Id: PrimeFinder.java, v 0.1 2017年12月21日 上午10:42:05 wxh Exp $
 */
public class PrimeFinder {

    /**
     * 查找素数
     */
    static void findPrimes() {
        int primeNum = 1;
        int numToCheck = 2;
        for (;;) {
            // 是否查找到素数，默认是找到素数的
            boolean foundPrime = true;
            for (int divisor = numToCheck / 2; divisor > 1; --divisor) {
                if (numToCheck % divisor == 0) {
                    // 不是素数，没有找到
                    foundPrime = false;
                    break;
                }
            }
            if (foundPrime) {
                // 是素数，找到了
                primeNum = numToCheck;
            }
            // 自增
            ++numToCheck;
        }
    }
}
