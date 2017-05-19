/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.test;

/**
 * 抽象类---最终目的派生出自己的子类，所以要有可扩展行，可复用性
 * 1.抽象方法一定是public /protected修饰
 * 2.如果一个类中有一个抽象方法，该类必须声明为抽象类
 * 3.抽象类可以有抽象方法，也可以没有，而且还可以有具体方法(实例方法)
 * 4.抽象类不能实例化，必须由其子类来实例化一个对象
 * 5.抽象类可以有自己的私有成员变量--这样就脱离抽象的本身意义
 * @author wxh
 * @version $Id: AbstractClass.java, v 0.1 2016年12月27日 下午2:02:21 wxh Exp $
 */
public abstract class AbstractClass {

    protected abstract void say();

    public abstract void walk();

    protected void eat() {
        System.out.println("吃饭。。。。。。");
    }

    int         a = 1;

    private int b;
}
