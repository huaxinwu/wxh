/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 解析constant_string_info入口
 * @author wxh
 * @version $Id: Example1.java, v 0.1 2017年12月13日 下午3:35:16 wxh Exp $
 */
public class Example1 {

    public static void main(String[] args) {
        String argZero = args[0];
        String literalString = "Hi!";
        System.out.println("before interning argZero:");
        if (argZero == literalString) {
            System.out.println("they are the same string objects!");
        } else {
            System.out.println("they are different string objects!");
        }
        argZero = argZero.intern();
        System.out.println("after interning argZero:");
        if (argZero == literalString) {
            System.out.println("they are the same string objects!");
        } else {
            System.out.println("they are different string objects!");
        }

    }
}
