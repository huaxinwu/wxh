/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 测试主动使用和被动使用类型的初始化
 * 只有Example2和NewPoint被初始化，NewBornBaby没有被初始化
 * @author wxh
 * @version $Id: Example2.java, v 0.1 2017年10月17日 下午3:46:39 wxh Exp $
 */
public class Example2 {

    static {
        System.out.println("Example2 was initialized.");
    }

    public static void main(String[] args) {
        int hours = NewBornBaby.hoursOfSleep;
        System.out.println(hours);
    }

}
