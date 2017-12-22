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
 * 连接鱼画布
 * @author wxh
 * @version $Id: LinkFishCanvas.java, v 0.1 2017年12月19日 下午4:46:54 wxh Exp $
 */
public class LinkFishCanvas extends AssignReferencesCanvas {

    /** */
    private static final long serialVersionUID                      = 535121963774133149L;

    private boolean           iconClicked                           = false;
    private boolean           yellowLocalVarClicked                 = false;
    private boolean           blueLocalVarClicked                   = false;
    private boolean           redLocalVarClicked                    = false;

    private Point             posOfMouseInsideIconWhenFirstPressed  = new Point(0, 0);
    private int               objectIndexOfFishIconThatWasClicked;

    private boolean           dragging                              = false;
    private Point             currentMouseDragPosition              = new Point(0, 0);
    private boolean           mouseIsOverAnIconThatCanBeDroppedUpon = false;
    private int               objectIndexOfIconThatCanBeDroppedUpon;

    /**
     * 在构造方法初始化参数
     * @param heap
     * @param locVars
     * @param ta
     */
    public LinkFishCanvas(GCHeap heap, LocalVariables locVars, HeapOfFishTextArea ta) {
        gcHeap = heap;
        localVars = locVars;
        controlPanelTextArea = ta;
    }

    /** 
     * 获取维度最小值
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
     * 鼠标按下操作
     * @param evt
     * @param x
     * @param y
     * @return
     * @see java.awt.Component#mouseDown(java.awt.Event, int, int)
     */
    public boolean mouseDown(Event evt, int x, int y) {

        // 首先检查鼠标是否在一个局部变量矩形中按下
        if (x >= xLocalVarRectStart && x < xLocalVarRectStart + localVarRectWidth
            && y >= yYellowFishLocalVarStart && y < yYellowFishLocalVarStart + localVarRectHeight) {

            yellowLocalVarClicked = true;
            return true;
        }
        if (x >= xLocalVarRectStart && x < xLocalVarRectStart + localVarRectWidth
            && y >= yBlueFishLocalVarStart && y < yBlueFishLocalVarStart + localVarRectHeight) {

            blueLocalVarClicked = true;
            return true;
        }
        if (x >= xLocalVarRectStart && x < xLocalVarRectStart + localVarRectWidth
            && y >= yRedFishLocalVarStart && y < yRedFishLocalVarStart + localVarRectHeight) {

            redLocalVarClicked = true;
            return true;
        }

        /**
         * 找出鼠标是否进入图标的热区。倒数计时在堆列表的顶部，
         * 以便稍后绘制的鱼将首先被找到。这是因为如果两个鱼重叠，
         * 数组中的一个将是绘制第二并出现在顶部。最好的鱼将首先找到这个for循环 
         */
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
                    break;
                }
            }
        }

        return true;
    }

    /** 
     * 鼠标松开操作
     * @param evt
     * @param x
     * @param y
     * @return
     * @see java.awt.Component#mouseUp(java.awt.Event, int, int)
     */
    public boolean mouseUp(Event evt, int x, int y) {

        if (!iconClicked && !yellowLocalVarClicked && !blueLocalVarClicked && !redLocalVarClicked) {
            return true;
        }

        if (!iconClicked) {

            Color colorOfClickedLocalVar = Color.yellow;
            if (blueLocalVarClicked) {
                colorOfClickedLocalVar = Color.cyan;
            } else if (redLocalVarClicked) {
                colorOfClickedLocalVar = Color.red;
            }

            if (dragging) {
                dragging = false;
                // Clear old line.  
                Graphics g = getGraphics();
                g.setColor(Color.blue);
                g.setXORMode(colorOfClickedLocalVar);

                int xLineStart = xLocalVarRectStart + localVarRectWidth;
                int yLineStart = yYellowFishLocalVarStart + (localVarRectHeight / 2);
                if (blueLocalVarClicked) {
                    yLineStart = yBlueFishLocalVarStart + (localVarRectHeight / 2);
                } else if (redLocalVarClicked) {
                    yLineStart = yRedFishLocalVarStart + (localVarRectHeight / 2);
                }

                if (!mouseIsOverAnIconThatCanBeDroppedUpon) {

                    g.drawLine(xLineStart, yLineStart, currentMouseDragPosition.x,
                        currentMouseDragPosition.y);
                } else {
                    ObjectHandle oh = gcHeap.getObjectHandle(objectIndexOfIconThatCanBeDroppedUpon);

                    g.drawRect(oh.fish.getFishPosition().x, oh.fish.getFishPosition().y,
                        oh.fish.getFishWidth(), oh.fish.getFishHeight());

                    g.drawLine(xLineStart, yLineStart, oh.fish.getFishPosition().x,
                        oh.fish.getFishPosition().y);

                    mouseIsOverAnIconThatCanBeDroppedUpon = false;

                    Point o = oh.fish.getFishPosition();
                    if (x >= o.x && x < o.x + oh.fish.getFishWidth() && y >= o.y
                        && y < o.y + oh.fish.getFishHeight()) {

                        if (oh.fish.getFishColor() == colorOfClickedLocalVar) {

                            if (yellowLocalVarClicked) {
                                localVars.yellowFish = objectIndexOfIconThatCanBeDroppedUpon;
                            } else if (blueLocalVarClicked) {
                                localVars.blueFish = objectIndexOfIconThatCanBeDroppedUpon;
                            } else if (redLocalVarClicked) {
                                localVars.redFish = objectIndexOfIconThatCanBeDroppedUpon;
                            }
                            repaint();
                        }
                    }
                }
            }

            yellowLocalVarClicked = false;
            blueLocalVarClicked = false;
            redLocalVarClicked = false;

            return true;
        }

        ObjectHandle fishObjectThatWasClicked = gcHeap
            .getObjectHandle(objectIndexOfFishIconThatWasClicked);
        FishIcon fishIconThatWasClicked = fishObjectThatWasClicked.fish;
        Color colorOfClickedFish = fishObjectThatWasClicked.fish.getFishColor();

        if (dragging) {
            dragging = false;
            Graphics g = getGraphics();
            g.setColor(Color.blue);
            g.setXORMode(colorOfClickedFish);

            Point lineStart = fishIconThatWasClicked.getFishNosePosition();

            if (!mouseIsOverAnIconThatCanBeDroppedUpon) {

                g.drawLine(lineStart.x, lineStart.y, currentMouseDragPosition.x,
                    currentMouseDragPosition.y);
            } else {
                ObjectHandle oh = gcHeap.getObjectHandle(objectIndexOfIconThatCanBeDroppedUpon);

                g.drawRect(oh.fish.getFishPosition().x, oh.fish.getFishPosition().y,
                    oh.fish.getFishWidth(), oh.fish.getFishHeight());

                g.drawLine(lineStart.x, lineStart.y, oh.fish.getFishPosition().x,
                    oh.fish.getFishPosition().y);

                mouseIsOverAnIconThatCanBeDroppedUpon = false;

                Point o = oh.fish.getFishPosition();
                if (x >= o.x && x < o.x + oh.fish.getFishWidth() && y >= o.y
                    && y < o.y + oh.fish.getFishHeight()) {

                    if ((objectIndexOfIconThatCanBeDroppedUpon != objectIndexOfFishIconThatWasClicked)
                        && fishCanLink(fishIconThatWasClicked, oh.fish)) {
                        int offset = getInstanceVariableOffset(fishIconThatWasClicked, oh.fish);

                        gcHeap.setObjectPool(fishObjectThatWasClicked.objectPos + offset,
                            objectIndexOfIconThatCanBeDroppedUpon);
                        repaint();
                    }
                }
            }
        }

        yellowLocalVarClicked = false;
        blueLocalVarClicked = false;
        redLocalVarClicked = false;
        iconClicked = false;

        return true;
    }

    /** 
     * 鼠标拖动操作
     * @param evt
     * @param x
     * @param y
     * @return
     * @see java.awt.Component#mouseDrag(java.awt.Event, int, int)
     */
    public boolean mouseDrag(Event evt, int x, int y) {

        if (!iconClicked && !yellowLocalVarClicked && !blueLocalVarClicked && !redLocalVarClicked) {
            return true;
        }

        if (yellowLocalVarClicked || blueLocalVarClicked || redLocalVarClicked) {

            Graphics g = getGraphics();
            g.setColor(Color.blue);
            Color colorOfClickedLocalVar = Color.yellow;
            int xLineStart = xLocalVarRectStart + localVarRectWidth;
            int yLineStart = yYellowFishLocalVarStart + (localVarRectHeight / 2);
            if (blueLocalVarClicked) {
                colorOfClickedLocalVar = Color.cyan;
                yLineStart = yBlueFishLocalVarStart + (localVarRectHeight / 2);
            } else if (redLocalVarClicked) {
                colorOfClickedLocalVar = Color.red;
                yLineStart = yRedFishLocalVarStart + (localVarRectHeight / 2);
            }
            g.setXORMode(colorOfClickedLocalVar);

            if (!dragging) {
                dragging = true;
            } else {
                if (mouseIsOverAnIconThatCanBeDroppedUpon) {
                    ObjectHandle oh = gcHeap.getObjectHandle(objectIndexOfIconThatCanBeDroppedUpon);
                    Point o = oh.fish.getFishPosition();
                    if (x < o.x || x >= o.x + oh.fish.getFishWidth() || y < o.y
                        || y >= o.y + oh.fish.getFishHeight()) {

                        g.drawRect(oh.fish.getFishPosition().x, oh.fish.getFishPosition().y,
                            oh.fish.getFishWidth(), oh.fish.getFishHeight());

                        g.drawLine(xLineStart, yLineStart, oh.fish.getFishPosition().x,
                            oh.fish.getFishPosition().y);

                        mouseIsOverAnIconThatCanBeDroppedUpon = false;
                    }
                } else {
                    g.drawLine(xLineStart, yLineStart, currentMouseDragPosition.x,
                        currentMouseDragPosition.y);
                }
            }

            for (int i = gcHeap.getHandlePoolSize() - 1; i >= 0; --i) {
                ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
                if (!oh.free) {

                    Point o = oh.fish.getFishPosition();
                    if (x >= o.x && x < o.x + oh.fish.getFishWidth() && y >= o.y
                        && y < o.y + oh.fish.getFishHeight()) {

                        if (!mouseIsOverAnIconThatCanBeDroppedUpon) {

                            if (oh.fish.getFishColor() == colorOfClickedLocalVar) {
                                mouseIsOverAnIconThatCanBeDroppedUpon = true;
                            }

                            if (mouseIsOverAnIconThatCanBeDroppedUpon) {
                                objectIndexOfIconThatCanBeDroppedUpon = i + 1;
                                g.drawRect(oh.fish.getFishPosition().x,
                                    oh.fish.getFishPosition().y, oh.fish.getFishWidth(),
                                    oh.fish.getFishHeight());

                                g.drawLine(xLineStart, yLineStart, oh.fish.getFishPosition().x,
                                    oh.fish.getFishPosition().y);
                            }
                        }
                        break;
                    }
                }
            }

            if (!mouseIsOverAnIconThatCanBeDroppedUpon) {
                g.drawLine(xLineStart, yLineStart, x, y);
            }
            currentMouseDragPosition.x = x;
            currentMouseDragPosition.y = y;

            g.setPaintMode();
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

        Point fishNose = fishIconThatWasClicked.getFishNosePosition();

        if (!dragging) {
            dragging = true;
        } else {
            if (mouseIsOverAnIconThatCanBeDroppedUpon) {
                ObjectHandle oh = gcHeap.getObjectHandle(objectIndexOfIconThatCanBeDroppedUpon);
                Point o = oh.fish.getFishPosition();
                if (x < o.x || x >= o.x + oh.fish.getFishWidth() || y < o.y
                    || y >= o.y + oh.fish.getFishHeight()) {

                    g.drawRect(oh.fish.getFishPosition().x, oh.fish.getFishPosition().y,
                        oh.fish.getFishWidth(), oh.fish.getFishHeight());

                    g.drawLine(fishNose.x, fishNose.y, oh.fish.getFishPosition().x,
                        oh.fish.getFishPosition().y);

                    mouseIsOverAnIconThatCanBeDroppedUpon = false;
                }
            } else {
                g.drawLine(fishNose.x, fishNose.y, currentMouseDragPosition.x,
                    currentMouseDragPosition.y);
            }
        }

        for (int i = gcHeap.getHandlePoolSize() - 1; i >= 0; --i) {
            ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
            if (!oh.free) {

                Point o = oh.fish.getFishPosition();
                if (x >= o.x && x < o.x + oh.fish.getFishWidth() && y >= o.y
                    && y < o.y + oh.fish.getFishHeight()) {

                    if (!mouseIsOverAnIconThatCanBeDroppedUpon) {
                        if (i + 1 == objectIndexOfFishIconThatWasClicked) {
                            break;
                        }

                        mouseIsOverAnIconThatCanBeDroppedUpon = fishCanLink(fishIconThatWasClicked,
                            oh.fish);
                        if (mouseIsOverAnIconThatCanBeDroppedUpon) {
                            objectIndexOfIconThatCanBeDroppedUpon = i + 1;
                            g.drawRect(oh.fish.getFishPosition().x, oh.fish.getFishPosition().y,
                                oh.fish.getFishWidth(), oh.fish.getFishHeight());
                            g.drawLine(fishNose.x, fishNose.y, oh.fish.getFishPosition().x,
                                oh.fish.getFishPosition().y);
                        }
                    }
                    break;
                }
            }
        }

        if (!mouseIsOverAnIconThatCanBeDroppedUpon) {
            g.drawLine(fishNose.x, fishNose.y, x, y);
        }
        currentMouseDragPosition.x = x;
        currentMouseDragPosition.y = y;

        g.setPaintMode();
        return true;
    }

    /**
     * 鱼可以连接操作
     * @param fromFish
     * @param toFish
     * @return
     */
    private boolean fishCanLink(FishIcon fromFish, FishIcon toFish) {

        if (fromFish.getFishColor() == Color.red) {
            return true;
        }

        if (fromFish.getFishColor() == Color.cyan) {
            if (toFish.getFishColor() != Color.red) {
                return true;
            } else {
                return false;
            }
        }

        if (toFish.getFishColor() == Color.yellow) {
            return true;
        }

        return false;
    }

    /**
     * 获取实例变量偏移量
     * @param fromFish
     * @param toFish
     * @return
     */
    private int getInstanceVariableOffset(FishIcon fromFish, FishIcon toFish) {

        if (fromFish.getFishColor() == Color.red) {
            if (toFish.getFishColor() == Color.red) {
                return 0;
            } else if (toFish.getFishColor() == Color.cyan) {
                return 1;
            } else {
                return 2;
            }
        }

        if (fromFish.getFishColor() == Color.cyan) {
            if (toFish.getFishColor() == Color.cyan) {
                return 0;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
