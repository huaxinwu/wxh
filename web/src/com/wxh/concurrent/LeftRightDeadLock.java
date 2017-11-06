/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 简单的锁顺序死锁(不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: LeftRightDeadLock.java, v 0.1 2017年11月6日 下午2:13:59 wxh Exp $
 */
public class LeftRightDeadLock {

    private final Object left  = new Object();
    private final Object right = new Object();

    /**
    *
    */
    private void doSomethingElse() {
    }

    /**
     *
     */
    private void doSomething() {
    }

    public void leftRight() {
        // 对象锁
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }

        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

}
