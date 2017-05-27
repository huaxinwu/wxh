/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * 我的应用小程序
 * @author wxh
 * @version $Id: MyApplet.java, v 0.1 2017年5月27日 下午3:53:33 wxh Exp $
 */
public class MyApplet extends Applet {
    String message;

    public void init() {
        message = "Hello World,I am alivel";
        repaint();
    }

    public void start() {
        message = "Now I am staruping up...";
        repaint();
    }

    public void stop() {
        message = "Now I am begining stopped...";
    }

    public void destory() {
        // 正在销毁
    }

    /** 
     * 绘制图形
     * @param g
     * @see java.awt.Container#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
        g.drawString(message, 5, 15);
    }

}
