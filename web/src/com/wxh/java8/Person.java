/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * jdk1.8特性：方法和构造方法的引用：Java8 允许你使用 :: 关键字来传递方法或者构造函数引用
 * @author wxh
 * @version $Id: Person.java, v 0.1 2018年2月6日 下午3:00:55 wxh Exp $
 */
public class Person {

    String firstName;
    String lastName;

    /**
     * 无参构造方法
     */
    public Person() {
    }

    /**
     *  有参构造方法
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
