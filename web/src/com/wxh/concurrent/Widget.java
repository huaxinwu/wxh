/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 窗口小组件
 * @author wxh
 * @version $Id: Widget.java, v 0.1 2017年10月24日 下午1:49:37 wxh Exp $
 */
public class Widget {
    public synchronized void doSomething() {
        System.out.println("synchronized...");
    }
}
