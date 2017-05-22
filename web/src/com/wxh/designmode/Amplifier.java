/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 功放
 * @author wxh
 * @version $Id: Amplifiter.java, v 0.1 2017年5月22日 下午2:52:36 wxh Exp $
 */
public class Amplifier {

    /**
     * 打开功放
     */
    public void on() {
        System.out.println("amp on");
    }

    /**
     * 设置模式为DVD
     * @param dvd
     */
    public void setDvd(DvdPlayer dvd) {
        System.out.println("amp set dvd");
    }

    /**
     * 环绕立体声
     */
    public void setSurroundSound() {
        System.out.println("amp set surround sound");
    }

    /**
     * 设置音量
     * @param num
     */
    public void Volume(int num) {
        System.out.println("amp set volume");
    }

    /**
     * 关闭功放
     */
    public void off() {
        System.out.println("amp off");
    }

}
