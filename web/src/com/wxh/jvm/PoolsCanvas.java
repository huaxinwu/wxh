/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * 一个模拟：垃圾收集堆
 * 池的画布
 * @author wxh
 * @version $Id: PoolsCanvas.java, v 0.1 2017年12月19日 下午4:01:41 wxh Exp $
 */
public class PoolsCanvas extends Canvas {

    /** */
    private static final long serialVersionUID = -1396052271921558991L;

    private GCHeap            gcHeap;
    private final int         poolImageInsets  = 5;

    /**
     * 初始化参数
     * @param heap
     */
    public PoolsCanvas(GCHeap heap) {
        gcHeap = heap;
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
     * 绘制图
     * @param g
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {

        Dimension dim = size();

        int xHandlePoolPortion = 0;
        int xArrowPortion = dim.width / 3;
        int xObjectPoolPortion = 2 * xArrowPortion;

        Font font = getFont();
        FontMetrics fm = getFontMetrics(font);

        int labelHeight = fm.getAscent() + fm.getDescent() + (2 * poolImageInsets);

        int heightAvailableForPools = dim.height - labelHeight - poolImageInsets;
        int objectPoolIntsCount = gcHeap.getObjectPoolSize();
        int handlePoolIntsCount = gcHeap.getHandlePoolSize() * 2;

        int maxIntsCount = objectPoolIntsCount;
        if (maxIntsCount < handlePoolIntsCount) {
            maxIntsCount = handlePoolIntsCount;
        }

        int yPixelsPerInt = heightAvailableForPools / maxIntsCount;

        int handlePoolHeight = handlePoolIntsCount * yPixelsPerInt;
        int objectPoolHeight = objectPoolIntsCount * yPixelsPerInt;

        int poolsWidth = xArrowPortion - poolImageInsets;

        int xTextStart = poolsWidth - fm.stringWidth(HeapOfFishStrings.handlePool);
        if (xTextStart < 0) {
            xTextStart = 0;
        }
        xTextStart /= 2;

        int yStart = (dim.height - handlePoolHeight - labelHeight - (2 * poolImageInsets)) / 2;
        if (yStart < 0) {
            yStart = 0;
        }
        g.setColor(Color.white);
        g.drawString(HeapOfFishStrings.handlePool, poolImageInsets + xTextStart,
            poolImageInsets + yStart + fm.getAscent());
        int yHandlePoolRect = yStart + labelHeight;
        g.fillRect(xHandlePoolPortion + poolImageInsets, yHandlePoolRect, poolsWidth,
            handlePoolHeight);

        xTextStart = poolsWidth - fm.stringWidth(HeapOfFishStrings.objectPool);
        if (xTextStart < 0) {
            xTextStart = 0;
        }
        xTextStart /= 2;

        yStart = (dim.height - objectPoolHeight - labelHeight - (2 * poolImageInsets)) / 2;
        if (yStart < 0) {
            yStart = 0;
        }

        g.drawString(HeapOfFishStrings.objectPool, xObjectPoolPortion + xTextStart,
            poolImageInsets + yStart + fm.getAscent());
        int yObjectPoolRect = yStart + labelHeight;
        //g.setColor(Color.white);  
        g.fillRect(xObjectPoolPortion, yObjectPoolRect, poolsWidth, objectPoolHeight);

        g.setColor(Color.black);
        int i = 0;
        while (i < objectPoolIntsCount) {

            for (int j = 0; j < yPixelsPerInt; ++j) {
                int yLinePos = yObjectPoolRect + (i * yPixelsPerInt) + j;
                g.drawLine(xObjectPoolPortion, yLinePos, xObjectPoolPortion + poolsWidth - 1,
                    yLinePos);
            }
            int header = gcHeap.getObjectPool(i);
            int length = gcHeap.getMemBlockLength(header);
            if (length <= 0) {
                break;
            }
            i += length;
        }

        for (i = 0; i < gcHeap.getHandlePoolSize(); ++i) {
            ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
            if (!oh.free) {

                Color color = Color.red;
                int objectSizeInInts = 3;
                if (oh.fish.getFishColor() == Color.cyan) {
                    color = Color.cyan;
                    objectSizeInInts = 2;
                } else if (oh.fish.getFishColor() == Color.yellow) {
                    color = Color.yellow;
                    objectSizeInInts = 1;
                }
                g.setColor(color);

                for (int j = 0; j < yPixelsPerInt * 2; ++j) {
                    int yLinePos = yHandlePoolRect + (i * yPixelsPerInt * 2) + j;
                    g.drawLine(xHandlePoolPortion + poolImageInsets, yLinePos, xHandlePoolPortion
                                                                               + poolImageInsets
                                                                               + poolsWidth - 1,
                        yLinePos);
                }

                for (int j = 0; j < yPixelsPerInt * objectSizeInInts; ++j) {
                    int yLinePos = yObjectPoolRect + (oh.objectPos * yPixelsPerInt) + j;
                    g.drawLine(xObjectPoolPortion, yLinePos, xObjectPoolPortion + poolsWidth - 1,
                        yLinePos);
                }
                int yArrowStart = yHandlePoolRect + (i * yPixelsPerInt * 2) + yPixelsPerInt;
                int yArrowEnd = yObjectPoolRect + (oh.objectPos * yPixelsPerInt)
                                + ((yPixelsPerInt * objectSizeInInts) / 2);
                g.drawLine(xHandlePoolPortion + poolImageInsets + poolsWidth + 2, yArrowStart,
                    xObjectPoolPortion - 3, yArrowEnd);
            }
        }
    }

}
