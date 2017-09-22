/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Map;

/**
 * Map.Entry骨架实现类,以前没有归纳入Java平台中，现在已经归纳了
 * 抽象类的演化比接口的演化要容易多：怎么理解？比如，你在抽象类中增加一个新方法，你可以增加一个具体方法，提供默认实现，
 * 然后抽象类所有已有实现都自动提供了这个新方法，接口则不行。
 * @author wxh
 * @version $Id: AbstractMapEntry.java, v 0.1 2017年9月8日 上午10:18:09 wxh Exp $
 */
public abstract class AbstractMapEntry implements Map.Entry {

    // 基本方法，供后续实现类使用
    public abstract Object getKey();

    public abstract Object getValue();

    /**
     * 两个对象比较
     * @param o1
     * @param o2
     * @return boolean
     */
    private static boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    /**
     * 修改Map必须重写此方法
     * @param value
     * @return
     * @see java.util.Map.Entry#setValue(java.lang.Object)
     */
    @Override
    public Object setValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry arg = (Map.Entry) o;
        return eq(getKey(), arg.getKey()) && eq(getValue(), arg.getValue());
    }

    @Override
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode())
               ^ (getValue() == null ? 0 : getValue().hashCode());
    }

    @Override
    public String toString() {
        return getKey() + "," + getValue();
    };
}
