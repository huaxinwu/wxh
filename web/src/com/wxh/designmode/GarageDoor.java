/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 车库门
 * @author wxh
 * @version $Id: GarageDoor.java, v 0.1 2017年4月20日 上午10:29:41 wxh Exp $
 */
public class GarageDoor {
    Object object;

    /**
     * 
     */
    public GarageDoor() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    public GarageDoor(Object object) {
        this.object = object;
    }

    /**
     * 上
     */
    public void up() {
        System.out.println("up");
    }

    /**
     * 下
     */
    public void down() {
        System.out.println("down");
    }

    /**
     * 停止
     */
    public void stop() {
        System.out.println("stop");
    }

    /**
     * 开灯
     */
    public void lightOn() {
        System.out.println("light is on");
    }

    /**
     * 关灯
     */
    public void lightOff() {
        System.out.println("light is off");
    }
}
