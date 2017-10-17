/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 主动使用和被动使用类型成初始化
 * @author wxh
 * @version $Id: NewPoint.java, v 0.1 2017年10月17日 下午3:35:45 wxh Exp $
 */
public class NewPoint {

    static int hoursOfSleep = (int) (Math.random() * 3.0);
    static {
        System.out.println("NewPoint was initialized.");
    }
}

class NewBornBaby extends NewPoint {
    static int hoursOfCrying = 6 + (int) (Math.random() * 2.0);
    static {
        System.out.println("NewBornBaby was initialized.");
    }
}
