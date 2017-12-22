/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;

/**
 * 一个模拟：垃圾收集堆
 * 中蓝鱼图标
 * @author wxh
 * @version $Id: MediumBlueFishIcon.java, v 0.1 2017年12月19日 下午4:51:35 wxh Exp $
 */
public class MediumBlueFishIcon extends FishIcon {

    /**
     * 在构造方法初始化参数
     * @param swim
     */
    public MediumBlueFishIcon(boolean swim) {

        fishPosition = new Point(0, 0);
        fishIsSwimming = swim;
        fishHasBeenInitiallyPositioned = false;

        fishColor = Color.cyan;

        topTail = new Point(0, 0);
        backTail = new Point(9, 12);
        bottomTail = new Point(0, 24);
        frontTail = new Point(15, 12);

        maxPaintsToHoldTailInOnePosition = 2;
        ovalPos = new Point(15, 3);
        ovalDim = new Dimension(30, 18);

        eyePos = new Point(38, 8);
        eyeDim = new Dimension(4, 4);

        staticTail.addPoint(frontTail.x, frontTail.y);
        staticTail.addPoint(topTail.x, topTail.y);
        staticTail.addPoint(backTail.x, backTail.y);
        staticTail.addPoint(bottomTail.x, bottomTail.y);
        staticTail.addPoint(frontTail.x, frontTail.y);

        if (fishIsSwimming) {
            swimmingTail[0] = new Polygon();
            swimmingTail[0].addPoint(frontTail.x, frontTail.y);
            swimmingTail[0].addPoint(topTail.x, topTail.y);
            swimmingTail[0].addPoint(backTail.x, backTail.y);
            swimmingTail[0].addPoint(bottomTail.x, bottomTail.y - 6);
            swimmingTail[0].addPoint(frontTail.x, frontTail.y);

            swimmingTail[1] = swimmingTail[0];

            swimmingTail[2] = new Polygon();
            swimmingTail[2].addPoint(frontTail.x, frontTail.y);
            swimmingTail[2].addPoint(topTail.x + 3, topTail.y + 1);
            swimmingTail[2].addPoint(backTail.x, backTail.y);
            swimmingTail[2].addPoint(bottomTail.x + 3, bottomTail.y - 5);
            swimmingTail[2].addPoint(frontTail.x, frontTail.y);

            swimmingTail[3] = new Polygon();
            swimmingTail[3].addPoint(frontTail.x, frontTail.y);
            swimmingTail[3].addPoint(topTail.x + 7, topTail.y + 3);
            swimmingTail[3].addPoint(backTail.x - 1, backTail.y);
            swimmingTail[3].addPoint(bottomTail.x + 7, bottomTail.y - 3);
            swimmingTail[3].addPoint(frontTail.x, frontTail.y);

            swimmingTail[4] = new Polygon();
            swimmingTail[4].addPoint(frontTail.x, frontTail.y);
            swimmingTail[4].addPoint(topTail.x + 3, topTail.y + 5);
            swimmingTail[4].addPoint(backTail.x, backTail.y);
            swimmingTail[4].addPoint(bottomTail.x + 3, bottomTail.y - 1);
            swimmingTail[4].addPoint(frontTail.x, frontTail.y);

            swimmingTail[5] = new Polygon();
            swimmingTail[5].addPoint(frontTail.x, frontTail.y);
            swimmingTail[5].addPoint(topTail.x, topTail.y + 6);
            swimmingTail[5].addPoint(backTail.x, backTail.y);
            swimmingTail[5].addPoint(bottomTail.x, bottomTail.y);
            swimmingTail[5].addPoint(frontTail.x, frontTail.y);

            swimmingTail[6] = swimmingTail[5];

            swimmingTail[7] = swimmingTail[5];
            swimmingTail[8] = swimmingTail[4];
            swimmingTail[9] = swimmingTail[3];
        }
    }

    /** 
     * 获取鱼的颜色
     * @return
     * @see com.wxh.jvm.FishIcon#getFishColor()
     */
    public Color getFishColor() {
        return Color.cyan;
    }
}
