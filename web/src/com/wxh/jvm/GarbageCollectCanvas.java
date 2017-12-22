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
 * 垃圾收集画布
 * @author wxh
 * @version $Id: GarbageCollectCanvas.java, v 0.1 2017年12月19日 下午4:34:41 wxh Exp $
 */
public class GarbageCollectCanvas extends Canvas {

    /** */
    private static final long  serialVersionUID                      = 4075338919173785580L;

    private GCHeap             gcHeap;
    private LocalVariables     localVars;
    private HeapOfFishTextArea controlPanelTextArea;

    /** 当前GC标记结点的颜色   */
    private Color              currentGCMarkNodeColor                = Color.magenta;

    private final int          poolImageInsets                       = 5;
    private final int          localVarStringMargin                  = 5;

    private int                localVarRectWidth;
    private int                localVarRectHeight;
    private int                xLocalVarRectStart;
    private int                yYellowFishLocalVarStart;
    private int                yBlueFishLocalVarStart;
    private int                yRedFishLocalVarStart;

    /** 鱼类区域只是在局部变量的左边 */
    private int                xFishAreaStart;

    /** 垃圾收集器还没有启动    */
    private final int          garbageCollectorHasNotStarted         = 0;

    private final int          startingAtYellowLocalVariableRoot     = 1;
    private final int          traversingFromYellowLocalVariableRoot = 2;
    private final int          doneWithYellowLocalVariableRoot       = 3;

    private final int          startingAtBlueLocalVariableRoot       = 4;
    private final int          traversingFromBlueLocalVariableRoot   = 5;
    private final int          doneWithBlueLocalVariableRoot         = 6;

    private final int          startingAtRedLocalVariableRoot        = 7;
    private final int          traversingFromRedLocalVariableRoot    = 8;
    private final int          doneWithRedLocalVariableRoot          = 9;

    private final int          readyToSweepUnmarkedFish              = 10;
    private final int          doneSweepingUnmarkedFish              = 11;

    private final int          garbageCollectorIsDone                = 12;

    private int                currentGCState                        = garbageCollectorHasNotStarted;

    private boolean            fishAreBeingMarked;
    private int                currentFishBeingMarked;

    private boolean            yellowFishLocalVarIsCurrentGCMarkNode;
    private boolean            blueFishLocalVarIsCurrentGCMarkNode;
    private boolean            redFishLocalVarIsCurrentGCMarkNode;

    private Color              yellowFishLocalVarLineColor;
    private Color              blueFishLocalVarLineColor;
    private Color              redFishLocalVarLineColor;

    /**
     * 在构造方法中初始化参数
     * @param heap
     * @param locVars
     * @param ta
     */
    public GarbageCollectCanvas(GCHeap heap, LocalVariables locVars, HeapOfFishTextArea ta) {
        setBackground(Color.blue);
        gcHeap = heap;
        localVars = locVars;
        controlPanelTextArea = ta;
    }

    /**
     * 遍历下一个鱼结点
     * @return
     */
    private boolean traverseNextFishNode() {
        ObjectHandle oh = gcHeap.getObjectHandle(currentFishBeingMarked);

        int myFriendIndex = gcHeap.getObjectPool(oh.objectPos);

        if ((myFriendIndex != 0) && (oh.myFriendLineColor == Color.white)) {
            oh.myFriendLineColor = Color.gray;
            ObjectHandle myFriend = gcHeap.getObjectHandle(myFriendIndex);
            myFriend.previousNodeInGCTraversalIsAFish = true;
            myFriend.previousFishInGCTraversal = currentFishBeingMarked;
            if (myFriend.myColor == Color.white) {
                myFriend.myColor = Color.gray;
            }
            currentFishBeingMarked = myFriendIndex;
            return false;
        } else if (oh.fish.getFishColor() == Color.yellow) {
            if (oh.previousNodeInGCTraversalIsAFish) {
                traverseBackFromGrayLine(oh.previousFishInGCTraversal);
                return false;
            }
            return true;
        }

        int myLunchIndex = gcHeap.getObjectPool(oh.objectPos + 1);

        if ((myLunchIndex != 0) && (oh.myLunchLineColor == Color.white)) {
            oh.myLunchLineColor = Color.gray;
            ObjectHandle myLunch = gcHeap.getObjectHandle(myLunchIndex);
            myLunch.previousNodeInGCTraversalIsAFish = true;
            myLunch.previousFishInGCTraversal = currentFishBeingMarked;
            if (myLunch.myColor == Color.white) {
                myLunch.myColor = Color.gray;
            }
            currentFishBeingMarked = myLunchIndex;
            return false;
        } else if (oh.fish.getFishColor() == Color.cyan) {
            if (oh.previousNodeInGCTraversalIsAFish) {
                traverseBackFromGrayLine(oh.previousFishInGCTraversal);
                return false;
            }
            return true;
        }

        int mySnackIndex = gcHeap.getObjectPool(oh.objectPos + 2);

        if ((mySnackIndex != 0) && (oh.mySnackLineColor == Color.white)) {
            oh.mySnackLineColor = Color.gray;
            ObjectHandle mySnack = gcHeap.getObjectHandle(mySnackIndex);
            mySnack.previousNodeInGCTraversalIsAFish = true;
            mySnack.previousFishInGCTraversal = currentFishBeingMarked;
            if (mySnack.myColor == Color.white) {
                mySnack.myColor = Color.gray;
            }
            currentFishBeingMarked = mySnackIndex;
            return false;
        } else if (oh.previousNodeInGCTraversalIsAFish) {
            traverseBackFromGrayLine(oh.previousFishInGCTraversal);
            return false;
        }

        return true;
    }

    /**
     * 遍历从浅色线条回来的
     * @param fishObjectHandle
     */
    private void traverseBackFromGrayLine(int fishObjectHandle) {

        ObjectHandle oh = gcHeap.getObjectHandle(fishObjectHandle);

        int myFriendIndex = gcHeap.getObjectPool(oh.objectPos);

        if ((myFriendIndex != 0) && (oh.myFriendLineColor == Color.gray)) {
            ObjectHandle myFriend = gcHeap.getObjectHandle(myFriendIndex);
            myFriend.previousNodeInGCTraversalIsAFish = false;
            myFriend.myColor = Color.black;
            oh.myFriendLineColor = Color.black;
            currentFishBeingMarked = fishObjectHandle;
            return;
        }

        if (oh.fish.getFishColor() == Color.yellow) {
            return; // exception condition  
        }

        int myLunchIndex = gcHeap.getObjectPool(oh.objectPos + 1);

        if ((myLunchIndex != 0) && (oh.myLunchLineColor == Color.gray)) {
            ObjectHandle myLunch = gcHeap.getObjectHandle(myLunchIndex);
            myLunch.previousNodeInGCTraversalIsAFish = false;
            myLunch.myColor = Color.black;
            oh.myLunchLineColor = Color.black;
            currentFishBeingMarked = fishObjectHandle;
            return;
        }

        if (oh.fish.getFishColor() == Color.cyan) {
            return; // exception condition  
        }

        int mySnackIndex = gcHeap.getObjectPool(oh.objectPos + 2);

        if ((mySnackIndex != 0) && (oh.mySnackLineColor == Color.gray)) {
            ObjectHandle mySnack = gcHeap.getObjectHandle(mySnackIndex);
            mySnack.previousNodeInGCTraversalIsAFish = false;
            mySnack.myColor = Color.black;
            oh.mySnackLineColor = Color.black;
            currentFishBeingMarked = fishObjectHandle;
            return;
        }
    }

    /**
     * 下一个GC阶段处理
     */
    public void nextGCStep() {

        switch (currentGCState) {
        // 垃圾收集器还没有启动的状态
            case garbageCollectorHasNotStarted:
                yellowFishLocalVarIsCurrentGCMarkNode = true;
                currentGCState = startingAtYellowLocalVariableRoot;
                controlPanelTextArea.setText(HeapOfFishStrings.traversingYellowRoot);
                break;

            case startingAtYellowLocalVariableRoot:

                yellowFishLocalVarIsCurrentGCMarkNode = false;
                if (localVars.yellowFish != 0) {

                    ObjectHandle oh = gcHeap.getObjectHandle(localVars.yellowFish);
                    yellowFishLocalVarIsCurrentGCMarkNode = false;
                    oh.myColor = Color.gray;
                    yellowFishLocalVarLineColor = Color.gray;
                    currentFishBeingMarked = localVars.yellowFish;
                    fishAreBeingMarked = true;
                    currentGCState = traversingFromYellowLocalVariableRoot;
                } else {
                    blueFishLocalVarIsCurrentGCMarkNode = true;
                    currentGCState = startingAtBlueLocalVariableRoot;
                    controlPanelTextArea.setText(HeapOfFishStrings.traversingBlueRoot);
                }
                break;

            case traversingFromYellowLocalVariableRoot:

                boolean doneWithThisTree = traverseNextFishNode();
                if (doneWithThisTree) {
                    ObjectHandle oh = gcHeap.getObjectHandle(localVars.yellowFish);
                    yellowFishLocalVarLineColor = Color.black;
                    oh.myColor = Color.black;
                    fishAreBeingMarked = false;
                    yellowFishLocalVarIsCurrentGCMarkNode = true;
                    currentGCState = doneWithYellowLocalVariableRoot;
                    controlPanelTextArea.setText(HeapOfFishStrings.doneWithYellowRoot);
                }
                break;

            case doneWithYellowLocalVariableRoot:

                yellowFishLocalVarIsCurrentGCMarkNode = false;
                blueFishLocalVarIsCurrentGCMarkNode = true;
                currentGCState = startingAtBlueLocalVariableRoot;
                controlPanelTextArea.setText(HeapOfFishStrings.traversingBlueRoot);
                break;

            case startingAtBlueLocalVariableRoot:

                blueFishLocalVarIsCurrentGCMarkNode = false;
                if (localVars.blueFish != 0) {

                    ObjectHandle oh = gcHeap.getObjectHandle(localVars.blueFish);
                    blueFishLocalVarIsCurrentGCMarkNode = false;
                    oh.myColor = Color.gray;
                    blueFishLocalVarLineColor = Color.gray;
                    currentFishBeingMarked = localVars.blueFish;
                    fishAreBeingMarked = true;
                    currentGCState = traversingFromBlueLocalVariableRoot;
                } else {
                    redFishLocalVarIsCurrentGCMarkNode = true;
                    currentGCState = startingAtRedLocalVariableRoot;
                    controlPanelTextArea.setText(HeapOfFishStrings.traversingRedRoot);
                }
                break;

            case traversingFromBlueLocalVariableRoot:

                doneWithThisTree = traverseNextFishNode();
                if (doneWithThisTree) {
                    ObjectHandle oh = gcHeap.getObjectHandle(localVars.blueFish);
                    blueFishLocalVarLineColor = Color.black;
                    oh.myColor = Color.black;
                    fishAreBeingMarked = false;
                    blueFishLocalVarIsCurrentGCMarkNode = true;
                    currentGCState = doneWithBlueLocalVariableRoot;
                    controlPanelTextArea.setText(HeapOfFishStrings.doneWithBlueRoot);
                }
                break;

            case doneWithBlueLocalVariableRoot:

                blueFishLocalVarIsCurrentGCMarkNode = false;
                redFishLocalVarIsCurrentGCMarkNode = true;
                currentGCState = startingAtRedLocalVariableRoot;
                controlPanelTextArea.setText(HeapOfFishStrings.traversingRedRoot);
                break;

            case startingAtRedLocalVariableRoot:

                redFishLocalVarIsCurrentGCMarkNode = false;
                if (localVars.redFish != 0) {

                    ObjectHandle oh = gcHeap.getObjectHandle(localVars.redFish);
                    redFishLocalVarIsCurrentGCMarkNode = false;
                    oh.myColor = Color.gray;
                    redFishLocalVarLineColor = Color.gray;
                    currentFishBeingMarked = localVars.redFish;
                    fishAreBeingMarked = true;
                    currentGCState = traversingFromRedLocalVariableRoot;
                } else {
                    currentGCState = readyToSweepUnmarkedFish;
                    controlPanelTextArea.setText(HeapOfFishStrings.readyToSweepUnmarkedFish);
                }
                break;

            case traversingFromRedLocalVariableRoot:

                doneWithThisTree = traverseNextFishNode();
                if (doneWithThisTree) {
                    ObjectHandle oh = gcHeap.getObjectHandle(localVars.redFish);
                    redFishLocalVarLineColor = Color.black;
                    oh.myColor = Color.black;
                    fishAreBeingMarked = false;
                    redFishLocalVarIsCurrentGCMarkNode = true;
                    currentGCState = doneWithRedLocalVariableRoot;
                    controlPanelTextArea.setText(HeapOfFishStrings.doneWithRedRoot);
                }
                break;

            case doneWithRedLocalVariableRoot:

                redFishLocalVarIsCurrentGCMarkNode = false;
                currentGCState = readyToSweepUnmarkedFish;
                controlPanelTextArea.setText(HeapOfFishStrings.readyToSweepUnmarkedFish);
                break;

            case readyToSweepUnmarkedFish:

                int objectsFreedCount = 0;
                for (int i = 0; i < gcHeap.getHandlePoolSize(); ++i) {
                    ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
                    if (!oh.free && oh.myColor == Color.white) {
                        gcHeap.freeObject(i + 1);
                        ++objectsFreedCount;
                    }
                }
                currentGCState = doneSweepingUnmarkedFish;
                String doneSweepingText = HeapOfFishStrings.sweptFish0 + objectsFreedCount
                                          + HeapOfFishStrings.sweptFish1;
                controlPanelTextArea.setText(doneSweepingText);
                break;

            case doneSweepingUnmarkedFish:
                currentGCState = garbageCollectorIsDone;
                controlPanelTextArea.setText(HeapOfFishStrings.garbageCollectionDone);
                break;

            case garbageCollectorIsDone:
            default:
                break;
        }
    }

    /**
     * 重置GC的状态
     */
    public void resetGCState() {

        for (int i = 0; i < gcHeap.getHandlePoolSize(); ++i) {
            ObjectHandle oh = gcHeap.getObjectHandle(i + 1);
            if (!oh.free) {
                oh.myColor = Color.white;
                oh.previousNodeInGCTraversalIsAFish = false;
                oh.previousFishInGCTraversal = 0;
                oh.myFriendLineColor = Color.white;
                oh.myLunchLineColor = Color.white;
                oh.mySnackLineColor = Color.white;
            }
        }
        currentGCState = garbageCollectorHasNotStarted;
        fishAreBeingMarked = false;
        yellowFishLocalVarIsCurrentGCMarkNode = false;
        blueFishLocalVarIsCurrentGCMarkNode = false;
        redFishLocalVarIsCurrentGCMarkNode = false;
        yellowFishLocalVarLineColor = Color.white;
        blueFishLocalVarLineColor = Color.white;
        redFishLocalVarLineColor = Color.white;
        controlPanelTextArea.setText(HeapOfFishStrings.garbageCollectInstructions);
    }

    /**
     *  绘制图 
     * @param g
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {

        Font font = g.getFont();
        FontMetrics fm = getFontMetrics(font);

        int localVarsStringWidth = fm.stringWidth(HeapOfFishStrings.localVariables);
        int redFishStringWidth = fm.stringWidth(HeapOfFishStrings.redFishLocalVar);
        int blueFishStringWidth = fm.stringWidth(HeapOfFishStrings.blueFishLocalVar);
        int yellowFishStringWidth = fm.stringWidth(HeapOfFishStrings.yellowFishLocalVar);

        localVarRectWidth = localVarsStringWidth;
        if (redFishStringWidth > localVarRectWidth) {
            localVarRectWidth = redFishStringWidth;
        }
        if (blueFishStringWidth > localVarRectWidth) {
            localVarRectWidth = blueFishStringWidth;
        }
        if (yellowFishStringWidth > localVarRectWidth) {
            localVarRectWidth = yellowFishStringWidth;
        }

        localVarRectWidth += 2 * localVarStringMargin;
        xFishAreaStart = localVarRectWidth + (2 * localVarStringMargin);

        localVarRectHeight = fm.getAscent() + fm.getDescent() + 2 * localVarStringMargin;

        Dimension dim = size();
        int yLocalVarsAreaStart = (dim.height - (4 * localVarRectHeight)) / 2;
        if (yLocalVarsAreaStart < 0) {
            yLocalVarsAreaStart = 0;
        }

        // 画本地变量 
        int xStart = ((localVarRectWidth - localVarsStringWidth) / 2) + localVarStringMargin;
        int yStart = yLocalVarsAreaStart + localVarStringMargin + fm.getAscent();
        g.setColor(Color.white);
        g.drawString(HeapOfFishStrings.localVariables, xStart, yStart);

        // 在黄色矩形中画黄色鱼
        xStart = localVarStringMargin;
        yStart = yLocalVarsAreaStart + localVarRectHeight;
        if (currentGCState == garbageCollectorHasNotStarted
            || currentGCState == garbageCollectorIsDone) {
            g.setColor(Color.yellow);
        } else if (yellowFishLocalVarIsCurrentGCMarkNode) {
            g.setColor(currentGCMarkNodeColor);
        } else {
            g.setColor(Color.white);
        }
        g.fillRect(xStart, yStart, localVarRectWidth, localVarRectHeight);
        xLocalVarRectStart = xStart;
        yYellowFishLocalVarStart = yStart;

        xStart = ((localVarRectWidth - yellowFishStringWidth) / 2) + localVarStringMargin;
        yStart += localVarStringMargin + fm.getAscent();
        g.setColor(Color.black);
        g.drawString(HeapOfFishStrings.yellowFishLocalVar, xStart, yStart);

        // 在浅青色矩形中画蓝色鱼
        xStart = localVarStringMargin;
        yStart = yLocalVarsAreaStart + (2 * localVarRectHeight);
        if (currentGCState == garbageCollectorHasNotStarted
            || currentGCState == garbageCollectorIsDone) {
            g.setColor(Color.cyan);
        } else if (blueFishLocalVarIsCurrentGCMarkNode) {
            g.setColor(currentGCMarkNodeColor);
        } else {
            g.setColor(Color.white);
        }
        g.fillRect(xStart, yStart, localVarRectWidth, localVarRectHeight);
        yBlueFishLocalVarStart = yStart;

        xStart = ((localVarRectWidth - blueFishStringWidth) / 2) + localVarStringMargin;
        yStart += localVarStringMargin + fm.getAscent();
        g.setColor(Color.black);
        g.drawString(HeapOfFishStrings.blueFishLocalVar, xStart, yStart);

        // 在红色矩形中画红色鱼 
        xStart = localVarStringMargin;
        yStart = yLocalVarsAreaStart + (3 * localVarRectHeight);
        if (currentGCState == garbageCollectorHasNotStarted
            || currentGCState == garbageCollectorIsDone) {
            g.setColor(Color.red);
        } else if (redFishLocalVarIsCurrentGCMarkNode) {
            g.setColor(currentGCMarkNodeColor);
        } else {
            g.setColor(Color.white);
        }
        g.fillRect(xStart, yStart, localVarRectWidth, localVarRectHeight);
        yRedFishLocalVarStart = yStart;

        xStart = ((localVarRectWidth - redFishStringWidth) / 2) + localVarStringMargin;
        yStart += localVarStringMargin + fm.getAscent();
        g.setColor(Color.black);
        g.drawString(HeapOfFishStrings.redFishLocalVar, xStart, yStart);

        if (localVars.yellowFish != 0) {
            g.setColor(Color.blue);
            if (currentGCState == garbageCollectorHasNotStarted
                || currentGCState == garbageCollectorIsDone) {
                g.setXORMode(Color.yellow);
            } else {
                g.setXORMode(yellowFishLocalVarLineColor);
            }
            ObjectHandle yf = gcHeap.getObjectHandle(localVars.yellowFish);
            int xLineStart = xLocalVarRectStart + localVarRectWidth;
            int yLineStart = yYellowFishLocalVarStart + (localVarRectHeight / 2);
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
            g.setPaintMode();
        }

        if (localVars.blueFish != 0) {
            g.setColor(Color.blue);
            if (currentGCState == garbageCollectorHasNotStarted
                || currentGCState == garbageCollectorIsDone) {
                g.setXORMode(Color.cyan);
            } else {
                g.setXORMode(blueFishLocalVarLineColor);
            }
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

        if (localVars.redFish != 0) {
            g.setColor(Color.blue);
            if (currentGCState == garbageCollectorHasNotStarted
                || currentGCState == garbageCollectorIsDone) {
                g.setXORMode(Color.red);
            } else {
                g.setXORMode(redFishLocalVarLineColor);
            }
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
                if (currentGCState == garbageCollectorHasNotStarted
                    || currentGCState == garbageCollectorIsDone) {
                    fishIcon.paint(g);
                } else {
                    if (fishAreBeingMarked && currentFishBeingMarked == i + 1) {
                        fishIcon.paintWithSpecialColors(g, currentGCMarkNodeColor, Color.black);
                    } else {
                        Color eyeColor = Color.black;
                        if (oh.myColor == Color.black) {
                            eyeColor = Color.white;
                        }
                        fishIcon.paintWithSpecialColors(g, oh.myColor, eyeColor);
                    }
                }

                // 画任何连接鱼的线 
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
                    if (currentGCState != garbageCollectorHasNotStarted
                        && currentGCState != garbageCollectorIsDone) {
                        g.setPaintMode();
                        g.setColor(Color.blue);
                        g.setXORMode(oh.myFriendLineColor);
                    }
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
                    if (currentGCState != garbageCollectorHasNotStarted
                        && currentGCState != garbageCollectorIsDone) {
                        g.setPaintMode();
                        g.setColor(Color.blue);
                        g.setXORMode(oh.myLunchLineColor);
                    }
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
                    if (currentGCState != garbageCollectorHasNotStarted
                        && currentGCState != garbageCollectorIsDone) {
                        g.setPaintMode();
                        g.setColor(Color.blue);
                        g.setXORMode(oh.mySnackLineColor);
                    }
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
