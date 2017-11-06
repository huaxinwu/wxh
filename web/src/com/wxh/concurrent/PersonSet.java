/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过封闭机制确保线程安全
 * 实例封闭是构建线程安全类的一个最简单方式
 * @author wxh
 * @version $Id: PersonSet.java, v 0.1 2017年10月25日 下午2:55:52 wxh Exp $
 */
@ThreadSafe
public class PersonSet {

    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }
}
