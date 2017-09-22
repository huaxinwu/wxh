/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 运算操作类(算术运算、逻辑运算、位移运算、指数、对数等等)
 * 可扩展、可序列化的类安全枚举类
 * @author wxh
 * @version $Id: Operation.java, v 0.1 2017年9月11日 上午10:04:47 wxh Exp $
 */
public abstract class Operation implements Serializable {

    /** */
    private static final long      serialVersionUID = 3357480791119891432L;
    /** 并发程序中不可序列化  */
    private final transient String name;

    /**
     * 计算方法
     * @param x
     * @param y
     * @return double
     */
    protected abstract double eval(double x, double y);

    /**
     * 匿名内部类
     * 相加
     */
    public static final Operation    PLUS        = new Operation("+") {
                                                     @Override
                                                     protected double eval(double x, double y) {
                                                         return x + y;
                                                     }
                                                 };
    /**
     * 相减
     */
    public static final Operation    MINUS       = new Operation("-") {
                                                     @Override
                                                     protected double eval(double x, double y) {
                                                         return x - y;
                                                     }
                                                 };
    /**
     * 相乘
     */
    public static final Operation    TIMES       = new Operation("*") {
                                                     @Override
                                                     protected double eval(double x, double y) {
                                                         return x * y;
                                                     }
                                                 };
    /**
     * 相除
     */
    public static final Operation    DIVIDE      = new Operation("/") {
                                                     @Override
                                                     protected double eval(double x, double y) {
                                                         return x / y;
                                                     }
                                                 };
    /** 序数  */
    private static int               nextOrdinal = 0;
    /** 基数  */
    private final int                ordinal     = nextOrdinal++;
    private static final Operation[] VALUES      = { PLUS, MINUS, TIMES, DIVIDE };

    /**
     * 反序列化解析出错，提供解析方法
     * @return Object
     * @throws ObjectStreamException
     */
    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];
    }

    /**
     * 受保护构造器
     * @param name
     */
    protected Operation(String name) {
        this.name = name;
    }

    @Override
    public final boolean equals(Object that) {
        return super.equals(that);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
