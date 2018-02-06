/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * jdk1.8特性：访问局部变量
 * @author wxh
 * @version $Id: LocalVarTest.java, v 0.1 2018年2月6日 下午3:33:25 wxh Exp $
 */
public class LocalVarTest {

    public static void main(String[] args) {
        final int num = 11;
        // 访问局部变量,此时num编译不通过
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        // 输出：2+11=13
        System.out.println("访问局部变量，结果：" + stringConverter.convert(2));
        // 在lambda表达式中试图修改num同样是不允许的
        //        num = 3;
    }

}
