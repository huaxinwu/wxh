/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 测试static final修饰的变量被动使用类型初始化
 * @author wxh
 * @version $Id: Example3.java, v 0.1 2017年10月17日 下午4:15:59 wxh Exp $
 */
public class Example3 {
    static {
        System.out.println("Example3 was initialized.s");
    }

    public static void main(String[] args) {
        System.out.println(Angry.greeting);
        System.out.println(Dog.greeting);
    }
}
