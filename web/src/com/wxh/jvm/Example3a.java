/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * Java程序成功返回两种情况：1.return 2.抛出异常
 * 
 * java 虚拟机内存结构：栈、堆、方法区
 * 栈区:
 * 1.每个线程包含一个栈区，栈中只保存基础数据类型的对象和自定义对象的引用(不是对象)，对象都存放在堆区中
 * 2.每个栈中的数据(原始类型和对象引用)都是私有的，其他栈不能访问。
 * 3.栈分为3个部分：基本类型变量区、执行环境上下文、操作指令区(存放操作指令)。
 * 堆区:
 * 1.存储的全部是对象，每个对象都包含一个与之对应的class的信息。(class的目的是得到操作指令)
 * 2.jvm只有一个堆区(heap)被所有线程共享，堆中不存放基本类型和对象引用，只存放对象本身
 * 方法区:
 * 1.又叫静态区，跟堆一样，被所有的线程共享。方法区包含所有的class和static变量。
 * 2.方法区中包含的都是在整个程序中永远唯一的元素，如class，static变量。
 * 
 * @author wxh
 * @version $Id: Example3a.java, v 0.1 2017年9月1日 上午10:19:36 wxh Exp $
 */
public class Example3a {
    /**
     * 类方法
     * 没有this
     * @param i
     * @param l
     * @param f
     * @param d
     * @param o
     * @param b
     * @return
     */
    public static int runClassMethod(int i, Long l, float f, double d, Object o, byte b) {
        return 0;
    }

    /**
     * 实例方法
     * 在栈帧会创建一个隐藏的引用类型参数this
     * char/short/boolean/byte在虚拟机中转换成int
     * @param c
     * @param d
     * @param s
     * @param b
     * @return
     */
    public static int runInstanceMethod(char c, double d, short s, boolean b) {
        return 0;
    }

    /**
     * 递归算法、
     * n的阶乘
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * 尾递归
     * @param n
     * @param result 
     * @return
     */
    public static int factorial(int n, int result) {
        if (n == 1) {
            // 相当于return 1
            return result;
        } else {
            return factorial(n - 1, n * result);
        }
    }

    /**
     * 尾递归优化解决的是内存溢出的问题，而垃圾回收解决的是内存泄露的问题
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;
        int result = 1;
        System.out.println("递归阶乘：" + factorial(n));
        System.out.println("尾递归阶乘：" + factorial(n, result));
    }
}
