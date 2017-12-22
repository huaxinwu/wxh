/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 * 一个模拟：垃圾收集堆
 * 鱼图标
 * // Fish Icon  
 * //  
 * // topTail   frontTail  
 * //      |\       |       /\  
 * //      |  \     |     /    \  
 * //       \   \   |   /        \  
 * //         \   \   /        o   \  
 * // backTail  >--><               >  
 * //         /   /   \            /  
 * //       /   /       \        /  
 * //       | /           \    /  
 * //       |/              \/  
 * // bottomTail  
 * //  
 * @author wxh
 * @version $Id: FishIcon.java, v 0.1 2017年12月19日 下午4:05:23 wxh Exp $
 */
public abstract class FishIcon {

    /** 顶部尾巴的位置  */
    protected Point     topTail;
    /**后尾的位置  */
    protected Point     backTail;
    /** 底部尾巴的位置 */
    protected Point     bottomTail;
    /** 前尾的位置  */
    protected Point     frontTail;
    /** 多边形对象，表示尾巴静止时形态    */
    protected Polygon   staticTail                = new Polygon();

    /** 游泳时尾巴位置数量   */
    protected final int swimmingTailPositionCount = 10;
    /** 多边形数组  */
    protected Polygon[] swimmingTail              = new Polygon[swimmingTailPositionCount];
    protected int       currentSwimmingTailPos    = 0;
    /** 保持尾部位置计数器 */
    protected int       holdTailPositionCounter   = 0;
    protected int       maxPaintsToHoldTailInOnePosition;

    /** 椭圆形位置  */
    protected Point     ovalPos;
    /** 椭圆形维度  */
    protected Dimension ovalDim;

    /** 眼睛位置   */
    protected Point     eyePos;
    protected Dimension eyeDim;

    protected Point     fishPosition;
    protected boolean   fishHasBeenInitiallyPositioned;

    protected boolean   fishIsSwimming;

    protected Color     fishColor;

    /**
     * 移动鱼
     * @param x
     * @param y
     */
    public void moveFish(int x, int y) {
        fishHasBeenInitiallyPositioned = true;
        fishPosition.x = x;
        fishPosition.y = y;
    }

    /**
     * 获取鱼的高度
     * @return
     */
    public int getFishHeight() {
        return bottomTail.y;
    }

    /**
     * 获取鱼的宽度
     * @return
     */
    public int getFishWidth() {
        return frontTail.x + ovalDim.width;
    }

    /**
     * 获取鱼的位置(坐标(x,y))
     * @return
     */
    public Point getFishPosition() {
        return new Point(fishPosition.x, fishPosition.y);
    }

    /**
     * 鱼是否已经初始化过位置信息
     * @return
     */
    public boolean getFishHasBeenInitiallyPositioned() {
        return fishHasBeenInitiallyPositioned;
    }

    /**
     * 获取鱼鼻子位置
     * @return
     */
    public Point getFishNosePosition() {
        return new Point(fishPosition.x + frontTail.x + ovalDim.width, fishPosition.y
                                                                       + (ovalDim.height / 2));
    }

    /**
     * 获取鱼的颜色
     * @return
     */
    public abstract Color getFishColor();

    /**
     * 绘制图
     * @param g
     */
    public void paint(Graphics g) {
        paintWithSpecialColors(g, fishColor, Color.black);
    }

    /**
     * 用特殊颜色绘制图
     * @param g
     * @param bodyColor
     * @param eyeColor
     */
    public void paintWithSpecialColors(Graphics g, Color bodyColor, Color eyeColor) {
        // 坐标点的转移
        g.translate(fishPosition.x, fishPosition.y);
        g.setColor(bodyColor);

        if (fishIsSwimming) {
            if (holdTailPositionCounter < maxPaintsToHoldTailInOnePosition) {
                ++holdTailPositionCounter;
            } else {
                holdTailPositionCounter = 0;
                ++currentSwimmingTailPos;
                if (currentSwimmingTailPos == swimmingTailPositionCount) {
                    currentSwimmingTailPos = 0;
                }
            }
            g.fillPolygon(swimmingTail[currentSwimmingTailPos]);
        } else {
            g.fillPolygon(staticTail);
        }

        g.fillOval(ovalPos.x, ovalPos.y, ovalDim.width, ovalDim.height);

        g.setColor(eyeColor);
        g.fillOval(eyePos.x, eyePos.y, eyeDim.width, eyeDim.height);

        g.translate(0 - fishPosition.x, 0 - fishPosition.y);
    }

    /**
     * 画鱼的轮廓
     * @param g
     * @param x
     * @param y
     */
    public void drawFishOutline(Graphics g, int x, int y) {

        g.translate(x, y);
        // 画多边形
        g.drawPolygon(staticTail);
        // 画椭圆形
        g.drawOval(ovalPos.x, ovalPos.y, ovalDim.width, ovalDim.height);

        g.drawOval(eyePos.x, eyePos.y, eyeDim.width, eyeDim.height);

        g.translate(0 - x, 0 - y);
    }
}
