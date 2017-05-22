/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 
 * @author wxh
 * @version $Id: HomeTheaterTestDriver.java, v 0.1 2017年5月22日 下午3:43:05 wxh Exp $
 */
public class HomeTheaterTestDriver {

    public static void main(String[] args) {

        // 实例化组件
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Projector projector = new Projector();
        TheaterLight light = new TheaterLight();
        Screen screen = new Screen();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector,
            light, screen, popper);
        // 夺宝奇兵电影
        homeTheater.watchMovie("Raiders of the lost Ark");
        homeTheater.endMovie();
    }
}
