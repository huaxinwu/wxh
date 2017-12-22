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
 * 组件堆画布
 * @author wxh
 * @version $Id: CompactHeapCanvas.java, v 0.1 2017年12月19日 下午4:25:27 wxh Exp $
 */
public class CompactHeapCanvas extends Canvas {
    /** */
    private static final long serialVersionUID = 8763163395934188922L;

    private GCHeap            gcHeap;
    private final int         poolImageInsets  = 5;

    /**
     * 构建一个GC堆
     * @param heap
     */
    public CompactHeapCanvas(GCHeap heap) {
        gcHeap = heap;
    }

    /** 
     * 绘制图
     * @param g
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {

        // 首先根据画布的宽度和高度计算画布上的位置 
        Dimension dim = size();

        // 把宽度分成三等份。左边部分将握住手柄池。右边部分将保存对象池。中间部分将有从有效句柄到相应对象的箭头  
        int xHandlePoolPortion = 0;
        int xArrowPortion = dim.width / 3;
        int xObjectPoolPortion = 2 * xArrowPortion;

        // 设置字体和画笔
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

        //g.setColor(Color.white);  
        g.drawString(HeapOfFishStrings.objectPool, xObjectPoolPortion + xTextStart,
            poolImageInsets + yStart + fm.getAscent());
        int yObjectPoolRect = yStart + labelHeight;
        //g.setColor(Color.white);  
        g.fillRect(xObjectPoolPortion, yObjectPoolRect, poolsWidth, objectPoolHeight);

        // 在对象池中绘制标题 
        g.setColor(Color.black);
        int i = 0;
        // 如果小于对象池插入的数目，遍历
        while (i < objectPoolIntsCount) {

            for (int j = 0; j < yPixelsPerInt; ++j) {
                int yLinePos = yObjectPoolRect + (i * yPixelsPerInt) + j;
                g.drawLine(xObjectPoolPortion, yLinePos, xObjectPoolPortion + poolsWidth - 1,
                    yLinePos);
            }
            int header = gcHeap.getObjectPool(i);
            int length = gcHeap.getMemBlockLength(header);
            //  如果对象池已损坏，请不要挂断
            if (length <= 0) {
                break;
            }
            i += length;
        }

        // 遍历，GC堆对象处理池中数目为循环次数
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

                // 绘制环绕对象处理池的线条
                for (int j = 0; j < yPixelsPerInt * 2; ++j) {
                    int yLinePos = yHandlePoolRect + (i * yPixelsPerInt * 2) + j;
                    g.drawLine(xHandlePoolPortion + poolImageInsets, yLinePos, xHandlePoolPortion
                                                                               + poolImageInsets
                                                                               + poolsWidth - 1,
                        yLinePos);
                }

                // 绘制颜色条来表示对象池中的对象  
                for (int j = 0; j < yPixelsPerInt * objectSizeInInts; ++j) {
                    int yLinePos = yObjectPoolRect + (oh.objectPos * yPixelsPerInt) + j;
                    g.drawLine(xObjectPoolPortion, yLinePos, xObjectPoolPortion + poolsWidth - 1,
                        yLinePos);
                }

                // 从句柄到对象画一条线，表示句柄指向对象
                int yArrowStart = yHandlePoolRect + (i * yPixelsPerInt * 2) + yPixelsPerInt;
                int yArrowEnd = yObjectPoolRect + (oh.objectPos * yPixelsPerInt)
                                + ((yPixelsPerInt * objectSizeInInts) / 2);
                g.drawLine(xHandlePoolPortion + poolImageInsets + poolsWidth + 2, yArrowStart,
                    xObjectPoolPortion - 3, yArrowEnd);
            }
        }
    }
}
