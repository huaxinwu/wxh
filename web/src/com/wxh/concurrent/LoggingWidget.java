/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 日志组件
 * @author wxh
 * @version $Id: LoggingWidget.java, v 0.1 2017年10月24日 下午1:53:42 wxh Exp $
 */
public class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": call doSomethiing");
        // 重写父类的方法，调用父类方法发生死锁
        super.doSomething();
    }
}