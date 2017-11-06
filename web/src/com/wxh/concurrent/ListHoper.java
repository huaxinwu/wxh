/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通过客户端加锁来实现“若没有则添加”
 * @author wxh
 * @version $Id: ListHoper.java, v 0.1 2017年10月26日 下午2:01:13 wxh Exp $
 * @param <E>
 */
@ThreadSafe
public class ListHoper<E> {

    private List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }

    }
}
