/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * jdk1.8特性：访问对象字段与静态变量
 * lambda内部对于实例的字段以及静态变量是即可读又可写
 * @author wxh
 * @version $Id: AccessObjectAndStaticVar.java, v 0.1 2018年2月6日 下午3:43:23 wxh Exp $
 */
public class AccessObjectAndStaticVar {

    static int outerStaticNum;
    int        outerNum;

    void testScope() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            // 访问对象的实例变量
            outerNum = 2;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            // 访问对象的类变量
            outerStaticNum = 12;
            return String.valueOf(from);
        };
    }
}
