/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 通过一个私有锁来保护状态
 * @author wxh
 * @version $Id: PrivateLock.java, v 0.1 2017年10月25日 下午3:12:16 wxh Exp $
 */
public class PrivateLock {

    private final Object myLock = new Object();
    @GuardedBy("myLock")
    private Widget       widget;

    void someMethod() {
        synchronized (myLock) {
            // 访问或者修改widget状态   
        }
    }
}
