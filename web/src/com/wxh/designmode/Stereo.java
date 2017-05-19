/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 音响
 * @author wxh
 * @version $Id: Stereo.java, v 0.1 2017年4月20日 下午4:59:29 wxh Exp $
 */
public class Stereo {

    Object object;

    /**
     * 
     */
    public Stereo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    public Stereo(Object object) {
        this.object = object;
    }

    public void on() {
        System.out.println("stereo on");
    }

    public void off() {
        System.out.println("stereo off");
    }

    public void setCd() {
        System.out.println("setcd");
    }

    public void setDvd() {
        System.out.println("setdvd");
    }

    public void setRadio() {
        System.out.println("setradio");
    }

    /**
     * 音量大小
     */
    public void setVolume(int val) {
        System.out.println("volume");
    }
}
