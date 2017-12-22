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
 * 大红色鱼图标
 * @author wxh
 * @version $Id: BigRedFishIcon.java, v 0.1 2017年12月19日 下午4:05:40 wxh Exp $
 */
public class BigRedFishIcon extends FishIcon {

    //Fish Icon  
    //
    //topTail   frontTail  
    //  |\       |       /\  
    //  |  \     |     /    \  
    //   \   \   |   /        \  
    //         \   \   /        o   \  
    //backTail  >--><               >  
    //         /   /   \            /  
    //   /   /       \        /  
    //   | /           \    /  
    //   |/              \/  
    //bottomTail  
    //

    /**
     * 在构造方法中初始化参数
     * @param swim
     */
    public BigRedFishIcon(boolean swim) {
        // 鱼的位置
        fishPosition = new Point(0, 0);
        // 鱼在游泳
        fishIsSwimming = swim;
        // 鱼是否已经初始化位置了
        fishHasBeenInitiallyPositioned = false;

        fishColor = Color.red;
        // 鱼的尾巴各个部位：顶部尾巴、后尾、底部尾巴、前尾
        topTail = new Point(0, 0);
        backTail = new Point(12, 16);
        bottomTail = new Point(0, 32);
        frontTail = new Point(20, 16);

        maxPaintsToHoldTailInOnePosition = 4;
        ovalPos = new Point(20, 4);
        ovalDim = new Dimension(40, 24);

        eyePos = new Point(52, 10);
        eyeDim = new Dimension(4, 4);
        // 不游泳时鱼尾巴各个部位位置
        staticTail.addPoint(frontTail.x, frontTail.y);
        staticTail.addPoint(topTail.x, topTail.y);
        staticTail.addPoint(backTail.x, backTail.y);
        staticTail.addPoint(bottomTail.x, bottomTail.y);
        staticTail.addPoint(frontTail.x, frontTail.y);

        // 游泳时鱼尾巴各个部位位置
        if (fishIsSwimming) {
            // 绘制多边形数组并且赋值
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
        return Color.red;
    }

}
