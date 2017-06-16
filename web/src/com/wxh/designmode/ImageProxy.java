/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 虚拟代理--控制访问创建开销大的资源
 * 实现Icon接口
 * @author wxh
 * @version $Id: ImageProxy.java, v 0.1 2017年6月13日 下午2:08:14 wxh Exp $
 */
public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL       imageURL;
    Thread    retrievalThread;
    boolean   retrieving = false;

    /**
     * 将URL传入构造器，表示希望显示的图片位置
     */
    public ImageProxy(URL url) {
        imageURL = url;
    }

    /** 
     * 渲染图片
     * @param c
     * @param g
     * @param x
     * @param y
     * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
     */
    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Loading CD cover,please wait...", x + 300, y + 190);
            // 没有回收
            if (!retrieving) {
                retrieving = true;
                // 匿名内部类
                retrievalThread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            imageIcon = new ImageIcon(imageURL, "CD cover");
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }

    /** 
     * 图片加载完毕前， 显示默认图片宽度
     * @return
     * @see javax.swing.Icon#getIconWidth()
     */
    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    /** 
     * 图片加载完毕前，显示默认图片高度
     * @return
     * @see javax.swing.Icon#getIconHeight()
     */
    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

}
