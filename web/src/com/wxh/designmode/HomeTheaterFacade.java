/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 
 * 设计模式：外观模式(提供了一个统一的接口，用来访问子系统中的一群接口，外观定义了一个高层接口，让子系统更容易使用。)
 * 最少知识原则：只和你的密友谈话
 * 家庭影院外观应用：打开爆米花机，开始爆米花，灯光调暗，放下屏幕，打开投影仪，设置为宽屏幕，打开功放，设置为DVD模式，设置
 * 立体环绕声，设置音量，打开DVD，播放电影等等。
 * @author wxh
 * @version $Id: HomeTheaterFacade.java, v 0.1 2017年5月22日 下午2:51:46 wxh Exp $
 */
public class HomeTheaterFacade {
    Amplifier     amp;
    Tuner         tuner;
    DvdPlayer     dvd;
    CdPlayer      cd;
    Projector     projector;
    TheaterLight  light;
    Screen        screen;
    PopcornPopper popper;

    // ....其他子组件

    /**
     * 
     */
    public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd, CdPlayer cd,
                             Projector projector, TheaterLight light, Screen screen,
                             PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.light = light;
        this.screen = screen;
        this.popper = popper;
    }

    // 其他方法

    /**
     * 观看电影
     * @param movie
     */
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        light.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.Volume(5);
        dvd.on();
        dvd.play(movie);
    }

    /**
     * 结束电影
     */
    public void endMovie() {
        System.out.println("shutting movie theater down...");
        popper.off();
        light.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}
