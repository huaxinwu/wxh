/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.ObjectStreamException;

/**
 * 扩展运算操作类
 * @author wxh
 * @version $Id: ExtendedOperation.java, v 0.1 2017年9月11日 上午10:38:24 wxh Exp $
 */
public abstract class ExtendedOperation extends Operation {

    /** */
    private static final long        serialVersionUID = -1447182749167741350L;
    /**
     * 对数 logarithm
     * 换底公式: logx(y) =loge(y) / loge(x),
     * 通底数相除的log得以除数为底数，以被除数为真数
     */
    public static Operation          LOG              = new ExtendedOperation("log") {

                                                          @Override
                                                          protected double eval(double x, double y) {
                                                              return Math.log(y) / Math.log(x);
                                                          }
                                                      };
    /**
     * 指数 exponential
     * aⁿ ,a为底数，n为指数
     */
    public static Operation          EXP              = new ExtendedOperation("exp") {

                                                          @Override
                                                          protected double eval(double x, double y) {
                                                              return Math.pow(x, y);
                                                          }
                                                      };
    /** 序数  */
    private static int               nextOrdinal      = 0;
    /** 基数  */
    private final int                ordinal          = nextOrdinal++;
    private static final Operation[] VALUES           = { LOG, EXP };

    /**
     * 反序列化解析出错，提供解析方法
     * @return Object
     * @throws ObjectStreamException
     */
    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];
    }

    /**
     * 父类没有定义一个默认构造器(public)，子类就必须实现其构造器
     * @param name
     */
    protected ExtendedOperation(String name) {
        super(name);
    }

}
