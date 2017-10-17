/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 类实例化四种方法：
 * 1.明确使用new操作符
 * 2.调用Class或者java.lang.reflect.Constructor对象的newInstance方法
 * 3.调用现有对象的clone方法
 * 4.通过java.io.ObjectInputStream类的getObject方法反序列化
 * @author wxh
 * @version $Id: Example4.java, v 0.1 2017年10月17日 下午4:33:36 wxh Exp $
 */
public class Example4 {

    Example4() {
        System.out.println("Created by invoking newInstance()");
    }

    Example4(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
                                          IllegalAccessException, CloneNotSupportedException {
        // 1. new实例化类
        Example4 obj1 = new Example4("Created with new.");

        // 2.调用Class的newInstance方法
        Class myClass = Class.forName("com.wxh.jvm.Example4");
        Example4 obj2 = (Example4) myClass.newInstance();

        // 3.调用现有对象的clone方法
        Example4 obj3 = (Example4) obj2.clone();
    }
}
