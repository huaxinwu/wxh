/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.math.BigInteger;
import java.util.Arrays;

import org.hibernate.annotations.Immutable;

/**
 * 对数值及因数分解结果进行缓存的不可变容器类
 * 对于访问和更新多个相关变量出现竞争条件时，将它们封装到一个不可变的类中。
 * @author wxh
 * @version $Id: OneValueCache.java, v 0.1 2017年10月25日 上午10:50:17 wxh Exp $
 */
@Immutable
public class OneValueCache {

    private final BigInteger   lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger bigInteger, BigInteger[] factors) {
        this.lastNumber = bigInteger;
        // 证明此类事不可变的类
        this.lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger biInteger) {
        if (lastNumber == null || !lastNumber.equals(biInteger)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
