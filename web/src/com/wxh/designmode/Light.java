/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 电灯产商
 * @author wxh
 * @version $Id: Light.java, v 0.1 2017年4月19日 下午3:22:44 wxh Exp $
 */
public class Light {
    Object object;

    public Light() {

    }

    /**
     * @param string
     */
    public Light(Object object) {
        this.object = object;
    }

    /**
     * 打开
     */
    public void on() {
        System.out.println("Light is on");
    }

    /**
     * 关闭
     */
    public void off() {
        System.out.println("Light is off");
    }
}
