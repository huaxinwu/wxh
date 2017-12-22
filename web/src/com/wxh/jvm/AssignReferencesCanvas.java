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
import java.awt.Point;

/**
 * 一个模拟：垃圾收集堆
 * 设置引用画布
 * @author wxh
 * @version $Id: AssignReferencesCanvas.java, v 0.1 2017年12月19日 下午4:07:55 wxh Exp $
 */
public class AssignReferencesCanvas extends Canvas {

    /** */
    private static final long    serialVersionUID     = 3897977614614671765L;

    protected GCHeap             gcHeap;
    /** 本地变量  */
    protected LocalVariables     localVars;
    protected HeapOfFishTextArea controlPanelTextArea;

    /** 池中插图的图片数量  */
    protected final int          poolImageInsets      = 5;
    /** 本地变量字符串间距  */
    protected final int          localVarStringMargin = 5;

    /** 本地变量矩形的宽度  */
    protected int                localVarRectWidth;
    protected int                localVarRectHeight;
    /** x在本地变量矩形上起点 */
    protected int                xLocalVarRectStart;
    /** 黄色鱼的y在本地变量矩形上的起点  */
    protected int                yYellowFishLocalVarStart;
    protected int                yBlueFishLocalVarStart;
    protected int                yRedFishLocalVarStart;

    /** x在鱼类区域起点  */
    protected int                xFishAreaStart;

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

        Font font = g.getFont();
        // 画笔
        FontMetrics fm = getFontMetrics(font);
        // 设置变量的长度
        int localVarsStringWidth = fm.stringWidth(HeapOfFishStrings.localVariables);
        int redFishStringWidth = fm.stringWidth(HeapOfFishStrings.redFishLocalVar);
        int blueFishStringWidth = fm.stringWidth(HeapOfFishStrings.blueFishLocalVar);
        int yellowFishStringWidth = fm.stringWidth(HeapOfFishStrings.yellowFishLocalVar);

        localVarRectWidth = localVarsStringWidth;
        // 如果红色鱼字符串长度大于本地变量字符串长度，进行赋值
        if (redFishStringWidth > localVarRectWidth) {
            localVarRectWidth = redFishStringWidth;
        }
        if (blueFishStringWidth > localVarRectWidth) {
            localVarRectWidth = blueFishStringWidth;
        }
        if (yellowFishStringWidth > localVarRectWidth) {
            localVarRectWidth = yellowFishStringWidth;
        }

        // 否则，本地变量矩形的宽度、高度、x起点都翻倍
        localVarRectWidth += 2 * localVarStringMargin;
        xFishAreaStart = localVarRectWidth + (2 * localVarStringMargin);
        localVarRectHeight = fm.getAscent() + fm.getDescent() + 2 * localVarStringMargin;

        // 获取维度
        Dimension dim = size();
        int yLocalVarsAreaStart = (dim.height - (4 * localVarRectHeight)) / 2;
        if (yLocalVarsAreaStart < 0) {
            yLocalVarsAreaStart = 0;
        }

        // 绘制图，绘制本地变量x、y 
        int xStart = ((localVarRectWidth - localVarsStringWidth) / 2) + localVarStringMargin;
        int yStart = yLocalVarsAreaStart + localVarStringMargin + fm.getAscent();
        g.setColor(Color.white);
        g.drawString(HeapOfFishStrings.localVariables, xStart, yStart);

        // 在黄色矩形里绘制黄色鱼的x、y 
        xStart = localVarStringMargin;
        yStart = yLocalVarsAreaStart + localVarRectHeight;
        g.setColor(Color.yellow);
        g.fillRect(xStart, yStart, localVarRectWidth, localVarRectHeight);
        xLocalVarRectStart = xStart;
        yYellowFishLocalVarStart = yStart;

        // 绘制图，绘制本地变量x、y 
        xStart = ((localVarRectWidth - yellowFishStringWidth) / 2) + localVarStringMargin;
        yStart += localVarStringMargin + fm.getAscent();
        g.setColor(Color.black);
        g.drawString(HeapOfFishStrings.yellowFishLocalVar, xStart, yStart);

        // 在蓝色矩形里绘制蓝色鱼的x、y   
        xStart = localVarStringMargin;
        yStart = yLocalVarsAreaStart + (2 * localVarRectHeight);
        g.setColor(Color.cyan);
        g.fillRect(xStart, yStart, localVarRectWidth, localVarRectHeight);
        yBlueFishLocalVarStart = yStart;

        // 绘制图，绘制本地变量x、y 
        xStart = ((localVarRectWidth - blueFishStringWidth) / 2) + localVarStringMargin;
        yStart += localVarStringMargin + fm.getAscent();
        g.setColor(Color.black);
        g.drawString(HeapOfFishStrings.blueFishLocalVar, xStart, yStart);

        // 在红色矩形里绘制红色鱼的x、y  
        xStart = localVarStringMargin;
        yStart = yLocalVarsAreaStart + (3 * localVarRectHeight);
        g.setColor(Color.red);
        g.fillRect(xStart, yStart, localVarRectWidth, localVarRectHeight);
        yRedFishLocalVarStart = yStart;

        // 绘制图，绘制本地变量x、y 
        xStart = ((localVarRectWidth - redFishStringWidth) / 2) + localVarStringMargin;
        yStart += localVarStringMargin + fm.getAscent();
        g.setColor(Color.black);
        g.drawString(HeapOfFishStrings.redFishLocalVar, xStart, yStart);
        // 如果黄色鱼位置不等于零，进行相关设置
        if (localVars.yellowFish != 0) {
            g.setColor(Color.blue);
            // 设置绘图模式为异或模式，颜色之间的异或运算，形成新的颜色(蓝色鱼黄色之间的交替颜色)
            g.setXORMode(Color.yellow);
            ObjectHandle yf = gcHeap.getObjectHandle(localVars.yellowFish);
            int xLineStart = xLocalVarRectStart + localVarRectWidth;
            // x轴的起点位置
            int yLineStart = yYellowFishLocalVarStart + (localVarRectHeight / 2);
            // 绘制线条，在(x1,y1)和(x2,y2)之间绘制的
            g.drawLine(xLineStart, yLineStart, yf.fish.getFishPosition().x,
                yf.fish.getFishPosition().y);
            if (localVars.yellowLineStart == null) {
                localVars.yellowLineStart = new Point(0, 0);
                localVars.yellowLineEnd = new Point(0, 0);
            }
            localVars.yellowLineStart.x = xLineStart;
            localVars.yellowLineStart.y = yLineStart;
            localVars.yellowLineEnd.x = yf.fish.getFishPosition().x;
            localVars.yellowLineEnd.y = yf.fish.getFishPosition().y;
            // 设置绘图模式为覆盖模式
            g.setPaintMode();
        }

        // 如果蓝色鱼位置不等于零，进行相关设置
        if (localVars.blueFish != 0) {
            g.setColor(Color.blue);
            g.setXORMode(Color.cyan);
            ObjectHandle bf = gcHeap.getObjectHandle(localVars.blueFish);
            int xLineStart = xLocalVarRectStart + localVarRectWidth;
            int yLineStart = yBlueFishLocalVarStart + (localVarRectHeight / 2);
            g.drawLine(xLineStart, yLineStart, bf.fish.getFishPosition().x,
                bf.fish.getFishPosition().y);
            if (localVars.blueLineStart == null) {
                localVars.blueLineStart = new Point(0, 0);
                localVars.blueLineEnd = new Point(0, 0);
            }
            localVars.blueLineStart.x = xLineStart;
            localVars.blueLineStart.y = yLineStart;
            localVars.blueLineEnd.x = bf.fish.getFishPosition().x;
            localVars.blueLineEnd.y = bf.fish.getFishPosition().y;
            g.setPaintMode();
        }

        // 如果红色鱼位置不等于零，进行相关设置
        if (localVars.redFish != 0) {
            g.setColor(Color.blue);
            g.setXORMode(Color.red);
            ObjectHandle rf = gcHeap.getObjectHandle(localVars.redFish);
            int xLineStart = xLocalVarRectStart + localVarRectWidth;
            int yLineStart = yRedFishLocalVarStart + (localVarRectHeight / 2);
            g.drawLine(xLineStart, yLineStart, rf.fish.getFishPosition().x,
                rf.fish.getFishPosition().y);
            if (localVars.redLineStart == null) {
                localVars.redLineStart = new Point(0, 0);
                localVars.redLineEnd = new Point(0, 0);
            }
            localVars.redLineStart.x = xLineStart;
            localVars.redLineStart.y = yLineStart;
            localVars.redLineEnd.x = rf.fish.getFishPosition().x;
            localVars.redLineEnd.y = rf.fish.getFishPosition().y;
            g.setPaintMode();
        }

        // 计算出三个槽中的每一个槽的位置  
        int columnCount = 3;
        int slotsPerColumn = gcHeap.getHandlePoolSize() / columnCount;
        if (gcHeap.getHandlePoolSize() % columnCount > 0) {
            ++slotsPerColumn;
        }
        int fishAreaWidth = dim.width - xFishAreaStart;
        int slotWidth = fishAreaWidth / columnCount;
        int slotHeight = dim.height / slotsPerColumn;

        // 遍历，GC堆中对象操作的个数为循环次数
        for (int i = 0; i < gcHeap.getHandlePoolSize(); ++i) {
            ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
            if (!oh.free) {
                FishIcon fishIcon = oh.fish;
                if (!fishIcon.getFishHasBeenInitiallyPositioned()) {
                    int column = i / slotsPerColumn;
                    int row = i % slotsPerColumn;
                    int xFishPosition = (int) ((double) (slotWidth - fishIcon.getFishWidth()) * Math
                        .random());
                    if (xFishPosition < 0) {
                        xFishPosition = 0;
                    }
                    xFishPosition += xFishAreaStart + (column * slotWidth);
                    int yFishPosition = (slotHeight - fishIcon.getFishHeight()) / 2;
                    if (yFishPosition < 0) {
                        yFishPosition = 0;
                    }
                    yFishPosition += row * slotHeight;
                    fishIcon.moveFish(xFishPosition, yFishPosition);
                }
                fishIcon.paint(g);

                // 绘制连接鱼的线条 
                g.setColor(Color.blue);
                g.setXORMode(fishIcon.getFishColor());
                Point fishNose = fishIcon.getFishNosePosition();

                oh.gotFriend = false;
                oh.myFriendLineStart = null;
                oh.myFriendLineEnd = null;

                oh.gotLunch = false;
                oh.myLunchLineStart = null;
                oh.myLunchLineEnd = null;

                oh.gotSnack = false;
                oh.mySnackLineStart = null;
                oh.mySnackLineEnd = null;

                int myFriendIndex = gcHeap.getObjectPool(oh.objectPos);

                if (myFriendIndex != 0) {
                    ObjectHandle myFriend = gcHeap.getObjectHandle(myFriendIndex);
                    g.drawLine(fishNose.x, fishNose.y, myFriend.fish.getFishPosition().x,
                        myFriend.fish.getFishPosition().y);
                    oh.gotFriend = true;
                    oh.myFriendLineStart = new Point(fishNose.x, fishNose.y);
                    oh.myFriendLineEnd = new Point(myFriend.fish.getFishPosition().x,
                        myFriend.fish.getFishPosition().y);
                }

                if (fishIcon.getFishColor() == Color.yellow) {
                    g.setPaintMode();
                    continue;
                }

                int myLunchIndex = gcHeap.getObjectPool(oh.objectPos + 1);

                if (myLunchIndex != 0) {
                    ObjectHandle myLunch = gcHeap.getObjectHandle(myLunchIndex);
                    g.drawLine(fishNose.x, fishNose.y, myLunch.fish.getFishPosition().x,
                        myLunch.fish.getFishPosition().y);
                    oh.gotLunch = true;
                    oh.myLunchLineStart = new Point(fishNose.x, fishNose.y);
                    oh.myLunchLineEnd = new Point(myLunch.fish.getFishPosition().x,
                        myLunch.fish.getFishPosition().y);
                }

                if (fishIcon.getFishColor() == Color.cyan) {
                    g.setPaintMode();
                    continue;
                }

                int mySnackIndex = gcHeap.getObjectPool(oh.objectPos + 2);

                if (mySnackIndex != 0) {
                    ObjectHandle mySnack = gcHeap.getObjectHandle(mySnackIndex);
                    g.drawLine(fishNose.x, fishNose.y, mySnack.fish.getFishPosition().x,
                        mySnack.fish.getFishPosition().y);
                    oh.gotSnack = true;
                    oh.mySnackLineStart = new Point(fishNose.x, fishNose.y);
                    oh.mySnackLineEnd = new Point(mySnack.fish.getFishPosition().x,
                        mySnack.fish.getFishPosition().y);
                }

                g.setPaintMode();
            }
        }
    }
}
