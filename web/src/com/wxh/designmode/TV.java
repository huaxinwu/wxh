/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 电视商
 * @author wxh
 * @version $Id: Light.java, v 0.1 2017年4月19日 下午3:22:44 wxh Exp $
 */
public class TV {
    Object object;

    public TV() {

    }

    /**
     * @param string
     */
    public TV(Object object) {
        this.object = object;
    }

    /**
     * 打开
     */
    public void on() {
        System.out.println("TV is on");
    }

    /**
     * 关闭
     */
    public void off() {
        System.out.println("TV is off");
    }
}
