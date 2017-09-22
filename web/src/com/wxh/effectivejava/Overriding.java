/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法重写(override)：选择是动态的，你传入什么类型，它会动态根据类的实例化来判断调用什么类型
 * @author wxh
 * @version $Id: Overriding.java, v 0.1 2017年9月11日 下午3:29:28 wxh Exp $
 */
public class Overriding {
    public static void main(String[] args) {
        A[] tests = new A[] { new A(), new B(), new C() };
        /// 输出 A B C，方法重写不会覆盖对应运行的类型
        for (int i = 0, length = tests.length; i < length; i++) {
            System.out.println("第" + i + "个元素：" + tests[i].name());
        }
        List<String> list = new ArrayList<String>();
        list.add("jond");
        list.add("boos");
        list.add("makds");
        System.out.println(Arrays.asList(list));
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class A {
    String name() {
        return "A";
    }
}

class B extends A {
    @Override
    String name() {
        return "B";
    }
}

class C extends A {
    @Override
    String name() {
        return "C";
    }
}
