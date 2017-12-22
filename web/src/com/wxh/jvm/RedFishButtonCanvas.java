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
 * 红色鱼按钮画布
 * @author wxh
 * @version $Id: RedFishButtonCanvas.java, v 0.1 2017年12月19日 下午4:56:04 wxh Exp $
 */
public class RedFishButtonCanvas extends Canvas {

    /** */
    private static final long serialVersionUID = 2734341271045247529L;

    private final int         fishButtonInset  = 5;
    private BigRedFishIcon    bigRedFishIcon   = new BigRedFishIcon(false);

    public RedFishButtonCanvas() {
        //setBackground(Color.white);  
    }

    /** 
     * 获取维度最小值
     * @return
     * @see java.awt.Component#minimumSize()
     */
    public Dimension minimumSize() {
        Dimension fishButtonDim = new Dimension(0, 0);
        fishButtonDim.width = bigRedFishIcon.getFishWidth() + (2 * fishButtonInset);
        fishButtonDim.height = bigRedFishIcon.getFishHeight() + (2 * fishButtonInset);
        return fishButtonDim;
    }

    /** 
     * 获取维度首选值
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

        Dimension dim = size();

        int xFishStart = (dim.width - bigRedFishIcon.getFishWidth()) / 2;
        if (xFishStart < 0) {
            xFishStart = 0;
        }

        int yFishStart = (dim.height - bigRedFishIcon.getFishHeight()) / 2;
        if (yFishStart < 0) {
            yFishStart = 0;
        }

        bigRedFishIcon.moveFish(xFishStart, yFishStart);

        bigRedFishIcon.paint(g);
    }
}
