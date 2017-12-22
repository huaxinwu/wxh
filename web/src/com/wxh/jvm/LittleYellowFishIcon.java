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
 * 小黄鱼图标
 * @author wxh
 * @version $Id: LittleYellowFishIcon.java, v 0.1 2017年12月19日 下午4:48:47 wxh Exp $
 */
public class LittleYellowFishIcon extends FishIcon {

    /**
     * 在构造方法初始化参数
     * @param swim
     */
    public LittleYellowFishIcon(boolean swim) {

        fishPosition = new Point(0, 0);
        fishIsSwimming = swim;
        fishHasBeenInitiallyPositioned = false;

        fishColor = Color.yellow;

        topTail = new Point(0, 0);
        backTail = new Point(6, 8);
        bottomTail = new Point(0, 16);
        frontTail = new Point(10, 8);

        maxPaintsToHoldTailInOnePosition = 1;
        ovalPos = new Point(10, 2);
        ovalDim = new Dimension(20, 12);

        eyePos = new Point(24, 5);
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
            swimmingTail[0].addPoint(bottomTail.x, bottomTail.y - 4);
            swimmingTail[0].addPoint(frontTail.x, frontTail.y);

            swimmingTail[1] = swimmingTail[0];

            swimmingTail[2] = new Polygon();
            swimmingTail[2].addPoint(frontTail.x, frontTail.y);
            swimmingTail[2].addPoint(topTail.x + 3, topTail.y + 1);
            swimmingTail[2].addPoint(backTail.x, backTail.y);
            swimmingTail[2].addPoint(bottomTail.x + 3, bottomTail.y - 3);
            swimmingTail[2].addPoint(frontTail.x, frontTail.y);

            swimmingTail[3] = new Polygon();
            swimmingTail[3].addPoint(frontTail.x, frontTail.y);
            swimmingTail[3].addPoint(topTail.x + 7, topTail.y + 2);
            swimmingTail[3].addPoint(backTail.x - 1, backTail.y);
            swimmingTail[3].addPoint(bottomTail.x + 7, bottomTail.y - 2);
            swimmingTail[3].addPoint(frontTail.x, frontTail.y);

            swimmingTail[4] = new Polygon();
            swimmingTail[4].addPoint(frontTail.x, frontTail.y);
            swimmingTail[4].addPoint(topTail.x + 3, topTail.y + 3);
            swimmingTail[4].addPoint(backTail.x, backTail.y);
            swimmingTail[4].addPoint(bottomTail.x + 3, bottomTail.y - 1);
            swimmingTail[4].addPoint(frontTail.x, frontTail.y);

            swimmingTail[5] = new Polygon();
            swimmingTail[5].addPoint(frontTail.x, frontTail.y);
            swimmingTail[5].addPoint(topTail.x, topTail.y + 4);
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
        return Color.yellow;
    }
}
