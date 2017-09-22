/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象类、接口都不能实例化，延迟到子类来实例化
 * @author wxh
 * @version $Id: Foo.java, v 0.1 2017年9月5日 上午10:54:48 wxh Exp $
 */
public abstract class Foo {
    private static Map<String, Object> implementions = null;

    /**
     * 公有的静态工厂方法所返回对象不仅可以是非公有的，而且该类可以随便每次调用次数而发生变化，取决于静态工厂方法的参数值。
     */
    private static synchronized void initMapIfNecessary() {
        if (implementions == null) {
            implementions = new HashMap<String, Object>();

        }
    }

    public static Foo getInstance(String key) {
        initMapIfNecessary();
        Class clazz = (Class) implementions.get(key);
        if (clazz == null) {
            // 多态
            return new DefaultFoo();
        }
        try {
            return (Foo) clazz.newInstance();
        } catch (InstantiationException e) {
            // 打印堆栈信息，实际开发一般会写入日志文件中
            e.printStackTrace();
            return new DefaultFoo();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new DefaultFoo();
        }
    }

    Foo() {
        System.out.println("parent constructor");
    }

    /** 
     * 任何类都有必要重写equals方法
     * @param o
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        throw new UnsupportedOperationException();
    }

}
