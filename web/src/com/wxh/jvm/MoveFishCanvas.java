/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 一个模拟：垃圾收集堆
 * 移动鱼的画布
 * @author wxh
 * @version $Id: MoveFishCanvas.java, v 0.1 2017年12月19日 下午4:53:12 wxh Exp $
 */
public class MoveFishCanvas extends AssignReferencesCanvas {

    /** */
    private static final long serialVersionUID                     = -5832206350081778382L;

    private boolean           iconClicked                          = false;
    private Point             posOfMouseInsideIconWhenFirstPressed = new Point(0, 0);
    private int               objectIndexOfFishIconThatWasClicked;

    private boolean           dragging                             = false;
    private Point             currentMouseDragPosition             = new Point(0, 0);

    /**
     * 在构造方法初始化参数
     * @param heap
     * @param locVars
     * @param ta
     */
    public MoveFishCanvas(GCHeap heap, LocalVariables locVars, HeapOfFishTextArea ta) {
        gcHeap = heap;
        localVars = locVars;
        controlPanelTextArea = ta;
    }

    /** 
     * 货物维度最小值
     * @return
     * @see com.wxh.jvm.AssignReferencesCanvas#minimumSize()
     */
    public Dimension minimumSize() {
        return new Dimension(500, 240);
    }

    /** 
     * 获取维度首选值
     * @return
     * @see com.wxh.jvm.AssignReferencesCanvas#preferredSize()
     */
    public Dimension preferredSize() {
        return new Dimension(500, 240);
    }

    /** 
     * 鼠标按下
     * @param evt
     * @param x
     * @param y
     * @return
     * @see java.awt.Component#mouseDown(java.awt.Event, int, int)
     */
    public boolean mouseDown(Event evt, int x, int y) {

        for (int i = gcHeap.getHandlePoolSize() - 1; i >= 0; --i) {
            ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
            if (!oh.free) {
                Point o = oh.fish.getFishPosition();
                if (x >= o.x && x < o.x + oh.fish.getFishWidth() && y >= o.y
                    && y < o.y + oh.fish.getFishHeight()) {

                    iconClicked = true;
                    objectIndexOfFishIconThatWasClicked = i + 1;
                    posOfMouseInsideIconWhenFirstPressed.x = x - o.x;
                    posOfMouseInsideIconWhenFirstPressed.y = y - o.y;
                    //fishObjectThatWasClicked = oh;  
                    break;
                }
            }
        }

        return true;
    }

    /** 
     * 鼠标松开
     * @param evt
     * @param x
     * @param y
     * @return
     * @see java.awt.Component#mouseUp(java.awt.Event, int, int)
     */
    public boolean mouseUp(Event evt, int x, int y) {

        if (iconClicked == false) {
            return true;
        }

        iconClicked = false;
        FishIcon fishIconThatWasClicked = gcHeap
            .getObjectHandle(objectIndexOfFishIconThatWasClicked).fish;
        Color colorOfClickedFish = gcHeap.getObjectHandle(objectIndexOfFishIconThatWasClicked).fish
            .getFishColor();

        if (dragging) {
            dragging = false;
            Graphics g = getGraphics();
            g.setColor(Color.blue);
            g.setXORMode(colorOfClickedFish);
            fishIconThatWasClicked.drawFishOutline(g, currentMouseDragPosition.x,
                currentMouseDragPosition.y);
            fishIconThatWasClicked.moveFish(currentMouseDragPosition.x, currentMouseDragPosition.y);
            repaint();
        }

        return true;
    }

    /** 
     * 鼠标拖动
     * @param evt
     * @param x
     * @param y
     * @return
     * @see java.awt.Component#mouseDrag(java.awt.Event, int, int)
     */
    public boolean mouseDrag(Event evt, int x, int y) {

        if (!iconClicked) {
            return true;
        }

        FishIcon fishIconThatWasClicked = gcHeap
            .getObjectHandle(objectIndexOfFishIconThatWasClicked).fish;
        Color colorOfClickedFish = gcHeap.getObjectHandle(objectIndexOfFishIconThatWasClicked).fish
            .getFishColor();

        if (!dragging) {
            int thresholdPixels = 5;
            Point iconOrigin = fishIconThatWasClicked.getFishPosition();
            int xOriginalClick = iconOrigin.x + posOfMouseInsideIconWhenFirstPressed.x;
            int yOriginalClick = iconOrigin.y + posOfMouseInsideIconWhenFirstPressed.y;
            int xDifference = x - xOriginalClick;
            if (xDifference < 0) {
                xDifference = 0 - xDifference;
            }
            int yDifference = y - yOriginalClick;
            if (yDifference < 0) {
                yDifference = 0 - yDifference;
            }
            if (xDifference < thresholdPixels && yDifference < thresholdPixels) {
                return true;
            }
        }

        Graphics g = getGraphics();
        g.setColor(Color.blue);
        g.setXORMode(colorOfClickedFish);

        if (!dragging) {
            dragging = true;
        } else {
            fishIconThatWasClicked.drawFishOutline(g, currentMouseDragPosition.x,
                currentMouseDragPosition.y);
        }

        int xNew = x - posOfMouseInsideIconWhenFirstPressed.x;
        int yNew = y - posOfMouseInsideIconWhenFirstPressed.y;

        if (xNew < xFishAreaStart) {
            xNew = xFishAreaStart;
        } else if (xNew + fishIconThatWasClicked.getFishWidth() - 1 > size().width) {
            xNew = size().width - fishIconThatWasClicked.getFishWidth() - 1;
        }

        if (yNew < 0) {
            yNew = 0;
        } else if (yNew + fishIconThatWasClicked.getFishHeight() - 1 > size().height) {

            yNew = size().height - fishIconThatWasClicked.getFishHeight() - 1;
        }

        fishIconThatWasClicked.drawFishOutline(g, xNew, yNew);
        currentMouseDragPosition.x = xNew;
        currentMouseDragPosition.y = yNew;

        g.setPaintMode();
        return true;
    }
}
