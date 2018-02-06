/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * jdk1.8特性：Lambda表达式,代码变得更短且更具有可读性,Java编译器可以自动推导出参数类型
 * 每一个lambda表达式都对应一个类型，通常是接口类型。
 * @author wxh
 * @version $Id: LambdaTest.java, v 0.1 2018年2月6日 下午2:26:07 wxh Exp $
 */
public class LambdaTest {

    public static void main(String[] args) {
        /**
         *  jdk1.8以前的版本写法
         */
        List<String> names = Arrays.asList("Lucy", "Lisa", "Tom", "John");

        // 只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        /**
         * jdk1.8版本写法
         */
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        // 还可以这样写
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        // 还可以更短，对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字,Java编译器可以自动推导出参数类型
        Collections.sort(names, (a, b) -> b.compareTo(a));

    }

}
