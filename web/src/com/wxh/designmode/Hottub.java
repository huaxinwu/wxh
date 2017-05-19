/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 热水器商
 * @author wxh
 * @version $Id: Light.java, v 0.1 2017年4月19日 下午3:22:44 wxh Exp $
 */
public class Hottub {
    Object object;

    public Hottub() {

    }

    /**
     * @param string
     */
    public Hottub(Object object) {
        this.object = object;
    }

    /**
     * 打开
     */
    public void on() {
        System.out.println("Hottub is on");
    }

    /**
     * 关闭
     */
    public void off() {
        System.out.println("Hottub is off");
    }
}
