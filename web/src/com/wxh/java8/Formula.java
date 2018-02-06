/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * jdk1.8特性：接口的默认方法---JavaSE 8允许我们给接口添加一个非抽象的方法实现，
 *      只需要使用 default关键字即可，这个特征又叫做扩展方法，
 *      Formula接口在拥有calculate方法之外同时还定义了sqrt方法，
 *      实现了Formula接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用
 * @author wxh
 * @version $Id: Formula.java, v 0.1 2018年2月6日 下午2:12:40 wxh Exp $
 */
public interface Formula {

    /**
     * 抽象方法--计算
     * @param a
     * @return double
     */
    double calculate(int a);

    /**
     * 接口的默认方法--求平方根
     * @param a
     * @return double
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
