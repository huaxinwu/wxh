/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * jdk1.8特性：在Java 8中支持多重注解
 * @author wxh
 * @version $Id: MultiAnnotation.java, v 0.1 2018年2月6日 下午4:34:07 wxh Exp $
 */
public class MultiAnnotation {

    public static void main(String[] args) {
        // 获取单一注解类
        Hint hint = Animal.class.getAnnotation(Hint.class);
        // null
        System.out.println(hint);

        // 获取多个注解
        Hints hints1 = Animal.class.getAnnotation(Hints.class);
        // 输出：2
        System.out.println(hints1.value().length);

        Hint[] hints2 = Animal.class.getAnnotationsByType(Hint.class);
        // 输出：2
        System.out.println(hints2.length);
    }

}
