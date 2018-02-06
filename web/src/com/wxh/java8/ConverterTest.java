/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * 函数式接口测试
 * @author wxh
 * @version $Id: ConverterTest.java, v 0.1 2018年2月6日 下午2:52:18 wxh Exp $
 */
public class ConverterTest {

    public static void main(String[] args) {

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("1234");
        System.out.println("String->Integer: " + converted);

        // Java8 允许你使用 :: 关键字来传递方法或者构造函数引用
        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter2.convert("4321");
        System.out.println("String->Integer: " + converted2);
    }

}
