/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Arrays;
import java.util.Set;

/**
 * 类反射
 * HashSet---随机的顺序排列
 * TreeSet---按照字母大小顺序排列
 * @author wxh
 * @version $Id: ClassReflect.java, v 0.1 2017年9月18日 下午2:39:29 wxh Exp $
 */
public class ClassReflect {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            System.exit(1);
        }
        Set s = null;
        try {
            s = (Set) c.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("class not accessible");
            // 非正常退出，强制退出  System.exit(0) 正常退出
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("class not instantible");
            System.exit(1);
        }
        s.addAll(Arrays.asList(args).subList(1, args.length - 1));
        System.out.println(s);
    }

}
