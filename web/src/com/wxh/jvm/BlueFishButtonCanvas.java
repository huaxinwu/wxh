/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * 一个模拟：垃圾收集堆
 * 蓝色鱼按钮画布
 * @author wxh
 * @version $Id: BlueFishButtonCanvas.java, v 0.1 2017年12月19日 下午4:19:53 wxh Exp $
 */
public class BlueFishButtonCanvas extends Canvas {

    /** */
    private static final long  serialVersionUID   = 5832086202267798287L;

    /** 鱼按钮插图初始值  */
    private final int          fishButtonInset    = 5;
    /** 中号蓝色鱼图标  */
    private MediumBlueFishIcon mediumBlueFishIcon = new MediumBlueFishIcon(false);

    public BlueFishButtonCanvas() {
        //setBackground(Color.white);  
    }

    /** 
     * 获取维度的最小值
     * @return
     * @see java.awt.Component#minimumSize()
     */
    public Dimension minimumSize() {
        Dimension fishButtonDim = new Dimension(0, 0);
        fishButtonDim.width = mediumBlueFishIcon.getFishWidth() + (2 * fishButtonInset);
        fishButtonDim.height = mediumBlueFishIcon.getFishHeight() + (2 * fishButtonInset);
        return fishButtonDim;
    }

    /** 
     * 获取维度的首选值
     * @return
     * @see java.awt.Component#preferredSize()
     */
    public Dimension preferredSize() {
        return minimumSize();
    }

    /** 
     * 绘制图
     * @param g
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {

        // 首先根据画布的宽度和高度计算画布上的位置  
        Dimension dim = size();
        int xFishStart = (dim.width - mediumBlueFishIcon.getFishWidth()) / 2;
        if (xFishStart < 0) {
            xFishStart = 0;
        }

        int yFishStart = (dim.height - mediumBlueFishIcon.getFishHeight()) / 2;
        if (yFishStart < 0) {
            yFishStart = 0;
        }

        mediumBlueFishIcon.moveFish(xFishStart, yFishStart);

        mediumBlueFishIcon.paint(g);
    }
}
