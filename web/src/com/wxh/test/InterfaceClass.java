/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.test;

/**
 * 接口
 * 1.可以有成员变量，但是必须是常量而且必须赋值，public static final String DEFAULT_CHAR = "1"; 
 * 2.方法必须是public修饰，只声明不能实现，由其子类实现
 * 3.接口与接口之间，可以多继承，多实现
 * 4.接口不能实例化
 * 5.可以有抽象方法，因为接口是抽象类的特例
 * @author wxh
 * @version $Id: InterfaceClass.java, v 0.1 2016年12月27日 下午2:12:54 wxh Exp $
 */
public interface InterfaceClass {

    int                        a       = 1;
    public static final String DEFAULT = "1";

    public abstract void eat();

    public void walk();
}
