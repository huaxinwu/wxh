/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 *  我的窗口
 * @author wxh
 * @version $Id: MyFrame.java, v 0.1 2017年5月27日 下午3:45:11 wxh Exp $
 */
public class MyFrame extends JFrame {

    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    /** 
     * 绘制图形
     * @param graphics
     * @see java.awt.Window#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
        super.paint(g);
        String msg = "I rule!!";
        g.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {

        MyFrame myFrame = new MyFrame("Head First Desgin Patterns");
    }
}
