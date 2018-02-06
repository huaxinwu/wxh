/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * 方法和构造方法的引用测试
 * @author wxh
 * @version $Id: PersonTest.java, v 0.1 2018年2月6日 下午3:08:41 wxh Exp $
 */
public class PersonTest {

    public static void main(String[] args) {
        // 使用构造方法引用来将工厂接口和对象关联起来
        PersonFactory<Person> personFactory = Person::new;
        // 构建对象
        Person person = personFactory.create("Peter", "Parter");

    }

}
