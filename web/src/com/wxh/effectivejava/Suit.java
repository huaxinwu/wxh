/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类型安全枚举
 * 子类构造器必须调用父类构造器
 * @author wxh
 * @version $Id: Suit.java, v 0.1 2017年9月8日 下午3:37:33 wxh Exp $
 */
public class Suit implements Comparable, Serializable {
    private final String        name;
    /** 序数  */
    private static int          nextOrdinal    = 0;
    /** 基数  */
    private int                 ordinal        = nextOrdinal++;
    /** 梅花  */
    public static final Suit    CLUBS          = new Suit("clubs");
    /** 方块  */
    public static final Suit    DIAMONDS       = new Suit("diamonds");
    /** 红桃  */
    public static final Suit    HEARTS         = new Suit("hearts");
    /** 黑桃  */
    public static final Suit    SPADES         = new Suit("spades");
    /**
     * 常量是对象，一般会放入集合中
     */
    private static final Suit[] PRIVATE_VALUES = { CLUBS, DIAMONDS, HEARTS, SPADES };
    public static final List    VALUES         = Collections.unmodifiableList(Arrays
                                                   .asList(PRIVATE_VALUES));

    /**
     * 序列化，必须提供反序列化的方法
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return PRIVATE_VALUES[ordinal];
    }

    private Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /** 
     * 两个对象比较
     * @param o
     * @return
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        return ordinal - ((Suit) o).ordinal;
    }

}
