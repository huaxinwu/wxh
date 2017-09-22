/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;


/**
 * 子类来实例化
 * @author wxh
 * @version $Id: DefaultFoo.java, v 0.1 2017年9月5日 上午11:05:05 wxh Exp $
 */
public class DefaultFoo extends Foo {

    public static void main(String[] args) {
        System.out.println(new DefaultFoo());
        Foo foo = new DefaultFoo();
        System.out.println(foo);
    }
}
