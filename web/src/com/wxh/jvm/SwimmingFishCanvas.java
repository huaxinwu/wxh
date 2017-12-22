/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 一个模拟：垃圾收集堆
 * 游泳鱼画布
 * @author wxh
 * @version $Id: SwimmingFishCanvas.java, v 0.1 2017年12月19日 下午4:57:38 wxh Exp $
 */
public class SwimmingFishCanvas extends Canvas implements Runnable {

    /** */
    private static final long    serialVersionUID         = -5633417695534326934L;

    private Thread               runner;

    private Image                offscreenImage;
    private Graphics             og;

    private final int            swimmingFishGroupWidth   = 150;
    private int                  xSwimmingFishGroupPos    = 0 - swimmingFishGroupWidth;
    private int                  ySwimmingFishGroupPos    = 20;
    private BigRedFishIcon       bigSwimmingRedFish       = new BigRedFishIcon(true);
    private MediumBlueFishIcon   mediumSwimmingBlueFish   = new MediumBlueFishIcon(true);
    private LittleYellowFishIcon littleSwimmingYellowFish = new LittleYellowFishIcon(true);

    /**
     * 初始化参数
     */
    public SwimmingFishCanvas() {
        setBackground(Color.blue);
    }

    /**
     * 启动
     */
    public void start() {
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }

    /**
     * 停止
     */
    public void stop() {
        if (runner != null) {
            runner.stop();
            runner = null;
        }
    }

    /** 
     *  运行
     * @see java.lang.Runnable#run()
     */
    public void run() {
        while (true) {

            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
    }

    /** 
     * 获取维度最小值
     * @return
     * @see java.awt.Component#minimumSize()
     */
    public Dimension minimumSize() {
        return new Dimension(500, 240);
    }

    /** 
     * 获取维度首选值
     * @return
     * @see java.awt.Component#preferredSize()
     */
    public Dimension preferredSize() {
        return new Dimension(500, 240);
    }

    /** 
     * 更新图
     * @param g
     * @see java.awt.Canvas#update(java.awt.Graphics)
     */
    public void update(Graphics g) {

        g.clipRect(xSwimmingFishGroupPos, ySwimmingFishGroupPos, swimmingFishGroupWidth + 1,
            bigSwimmingRedFish.getFishHeight());
        paint(g);
    }

    /** 
     * 绘制图
     * @param g
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {

        Dimension dim = size();

        if (offscreenImage == null) {

            offscreenImage = createImage(dim.width, dim.height);
            og = offscreenImage.getGraphics();
        }

        int yHandlePoolPortion = dim.height / 3;
        int yModeDependentPortion = 2 * yHandlePoolPortion;

        xSwimmingFishGroupPos += 1;

        if (xSwimmingFishGroupPos > size().width) {

            int yRange = dim.height - bigSwimmingRedFish.getFishHeight() - 10;
            ySwimmingFishGroupPos = (int) (((double) yRange) * Math.random());
            ySwimmingFishGroupPos += 5;

            xSwimmingFishGroupPos = 0 - swimmingFishGroupWidth;
        }

        bigSwimmingRedFish.moveFish(xSwimmingFishGroupPos, ySwimmingFishGroupPos);
        mediumSwimmingBlueFish.moveFish(xSwimmingFishGroupPos + 67, ySwimmingFishGroupPos + 4);
        littleSwimmingYellowFish.moveFish(xSwimmingFishGroupPos + 120, ySwimmingFishGroupPos + 8);

        og.setColor(Color.blue);
        og.fillRect(0, 0, dim.width, dim.height);

        bigSwimmingRedFish.paint(og);
        mediumSwimmingBlueFish.paint(og);
        littleSwimmingYellowFish.paint(og);

        g.drawImage(offscreenImage, 0, 0, this);
    }

}
