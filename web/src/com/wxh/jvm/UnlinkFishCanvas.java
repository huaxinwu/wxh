/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;

/**
 * 一个模拟：垃圾收集堆
 * 断开连接鱼画布
 * @author wxh
 * @version $Id: UnlinkFishCanvas.java, v 0.1 2017年12月19日 下午5:01:53 wxh Exp $
 */
public class UnlinkFishCanvas extends AssignReferencesCanvas {

    /** */
    private static final long serialVersionUID                      = -7455309086461433085L;

    private boolean           iconClicked                           = false;
    private boolean           overYellowLocalVarLine                = false;
    private boolean           overBlueLocalVarLine                  = false;
    private boolean           overRedLocalVarLine                   = false;
    private boolean           overInterFishLine                     = false;

    private Point             interFishLineStart;
    private Point             interFishLineEnd;
    private int               interFishRefToClear;
    private Color             interFishLineColor;

    private Point             posOfMouseInsideIconWhenFirstPressed  = new Point(0, 0);
    private int               objectIndexOfFishIconThatWasClicked;

    private boolean           dragging                              = false;
    private Point             currentMouseDragPosition              = new Point(0, 0);
    private boolean           mouseIsOverAnIconThatCanBeDroppedUpon = false;
    private int               objectIndexOfIconThatCanBeDroppedUpon;

    private Color             colorOfUnlinkableLine                 = Color.black;

    private final int         extraZeros                            = 1000;

    // mouseFatness is the number of pixels around the mouse which will form the rectangle
    // that a line must cross for it to be unlinked.
    private int               mouseFatness                          = 3;

    UnlinkFishCanvas(GCHeap heap, LocalVariables locVars, HeapOfFishTextArea ta) {

        gcHeap = heap;
        localVars = locVars;
        controlPanelTextArea = ta;

    }

    public Dimension minimumSize() {

        return new Dimension(500, 240);

    }

    public Dimension preferredSize() {

        return new Dimension(500, 240);

    }

    public boolean mouseDrag(Event evt, int x, int y) {

        return mouseMove(evt, x, y);

    }
}
