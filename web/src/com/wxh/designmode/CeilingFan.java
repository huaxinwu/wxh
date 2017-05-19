/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 吊顶风扇
 * @author wxh
 * @version $Id: CeilingFan.java, v 0.1 2017年4月20日 下午5:27:12 wxh Exp $
 */
public class CeilingFan {
    Object                  object;
    /** 高转速  */
    public static final int HIGH   = 3;
    /** 中转速  */
    public static final int MEDIUM = 2;
    /** 低转速  */
    public static final int LOW    = 1;
    /** 关闭转速  */
    public static final int OFF    = 0;
    /** 位置 */
    String                  location;
    /** 转速速度  */
    int                     speed;

    /**
     * 吊扇开始关闭的，具体位置在哪里
     * @param location
     */
    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
    }

    public void medium() {
        speed = MEDIUM;
    }

    public void low() {
        speed = LOW;
    }

    /**
     * 
     */
    public CeilingFan(Object object) {
        this.object = object;
    }

    /**
     * 打开
     */
    public void on() {
        System.out.println("CeilingFan is on");
    }

    /**
     * 关闭
     */
    public void off() {
        System.out.println("CeilingFan is off");
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
