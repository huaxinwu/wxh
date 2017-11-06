/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 失效值问题更容易出现，非线程安全可变正整数
 * @author wxh
 * @version $Id: MutableInteger.java, v 0.1 2017年10月24日 下午3:14:51 wxh Exp $
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
