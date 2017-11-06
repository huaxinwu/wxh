/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.Vector;

/**
 * 若没有则添加
 * @author wxh
 * @version $Id: BetterVector.java, v 0.1 2017年10月26日 上午11:37:41 wxh Exp $
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E e) {
        boolean absent = !contains(e);
        if (absent) {
            add(e);
        }
        return absent;
    }

}
