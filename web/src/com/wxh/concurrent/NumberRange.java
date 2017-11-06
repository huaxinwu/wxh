/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 该类不足以保护不变性条件(不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: NumberRange.java, v 0.1 2017年10月26日 上午11:10:17 wxh Exp $
 */
public class NumberRange {

    // 不变性条件： lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLoer(int i) {
        // 注意：不安全的，先检查后执行
        if (i > upper.get()) {
            throw new IllegalArgumentException("can not set lower to  " + i + "> upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // 注意：不安全的，先检查后执行
        if (i < lower.get()) {
            throw new IllegalArgumentException("can not set upper to  " + i + "< lower");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
