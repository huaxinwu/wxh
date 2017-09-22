/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 实现Comparable接口，比较两个对象,顺序比较，在ASCII表对应每个字符数值的比较
 * @author wxh
 * @version $Id: WordList.java, v 0.1 2017年9月6日 下午3:56:26 wxh Exp $
 */
public class WordList {

    public static void main(String[] args) {
        Set s = new TreeSet();
        s.addAll(Arrays.asList(args));
        System.out.println(s);
    }

}
