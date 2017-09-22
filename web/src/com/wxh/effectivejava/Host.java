/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.Serializable;
import java.util.Comparator;

/**
 * java类和接口代替C语言指针，主要是为了实现策略模式
 * @author wxh
 * @version $Id: Host.java, v 0.1 2017年9月11日 上午11:30:47 wxh Exp $
 */
public class Host {

    /**
     * 字符串长度组件
     */
    private static class StrLenCmp implements Comparator, Serializable {

        /** 
         * 比较两个对象内容
         * @param o1
         * @param o2
         * @return
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            // 大于返回1，小于返回-1，等于返回0
            return s1.length() - s2.length();
        }

    }

    //  通过大小写不敏感得到一个字符串比较器
    public static final Comparator STRING_LENGTH_COMPARATOR = new StrLenCmp();
}
