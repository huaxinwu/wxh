/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * jdk1.8特性：函数式接口是指仅仅只包含一个抽象方法的接口
 * 通过注解@FunctionalInterface来标记位函数式接口
 * @author wxh
 * @version $Id: Converter.java, v 0.1 2018年2月6日 下午2:45:19 wxh Exp $
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
