/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 不正确的发布对象，导致断言错误
 * @author wxh
 * @version $Id: Holder.java, v 0.1 2017年10月25日 上午11:03:15 wxh Exp $
 */
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("This is statement is false.");
        }
    }

}
