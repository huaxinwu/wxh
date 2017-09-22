/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合分类器
 * 方法重载(overload):选择是静态类型，你传入什么类型，它就用什么类型
 * c重写机制是规范，重载机制是例外
 * @author wxh
 * @version $Id: CollectionClassifier.java, v 0.1 2017年9月11日 下午3:13:04 wxh Exp $
 */
public class CollectionClassifier {

    public static String classify(Set s) {
        return "Set";
    }

    public static String classify(List l) {
        return "List";
    }

    public static String classify(Collection c) {
        //        return "Unknown Collection";
        // 用一个方法能替换三种重载方法---三目运算
        return (c instanceof Set ? "Set" : (c instanceof List ? "List" : "Unknown Collection"));
    }

    public static void main(String[] args) {
        Collection[] tests = new Collection[] { new HashSet(), new ArrayList(),
                new HashMap().values() };
        // 每次循环使用tests.length，计算结果增加内存开销，建议这样编写
        // 期望输出Set List Unkown Collection，事实是三个Unkown Collection，原因是方法重载
        for (int i = 0, length = tests.length; i < length; i++) {
            System.out.println("第" + i + "个元素: " + classify(tests[i]));
        }
    }
}
