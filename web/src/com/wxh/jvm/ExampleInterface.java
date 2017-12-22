/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 接口变量可以指向多个实现类的引用
 * @author wxh
 * @version $Id: ExampleInterface.java, v 0.1 2017年12月14日 上午10:31:46 wxh Exp $
 */
public class ExampleInterface {

    public static void main(String[] args) {
        Dog2 dog = new CokerSpaniel();
        dog.sayHello();
        // 指向CokerSpaniel的引用
        Friendly friendly = (Friendly) dog;
        friendly.sayGoodbye();
        // 指向Cat的引用
        friendly = new Cat();
        friendly.sayGoodbye();
    }

}
