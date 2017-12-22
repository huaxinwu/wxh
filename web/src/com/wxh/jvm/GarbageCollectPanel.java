/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 垃圾收集面板
 * @author wxh
 * @version $Id: GarbageCollectPanel.java, v 0.1 2017年12月19日 下午4:36:33 wxh Exp $
 */
public class GarbageCollectPanel extends Panel {

    /** */
    private static final long    serialVersionUID = 6559417362127695637L;

    private GarbageCollectCanvas gcCanvas;

    /**
     * 在构造方法中初始化参数
     * @param heap
     * @param locVars
     * @param ta
     */
    public GarbageCollectPanel(GCHeap heap, LocalVariables locVars, HeapOfFishTextArea ta) {

        setBackground(Color.blue);

        setLayout(new BorderLayout());

        gcCanvas = new GarbageCollectCanvas(heap, locVars, ta);

        add("South", new GarbageCollectButtonPanel());
        add("Center", gcCanvas);
    }

    /**
     * 重置GC状态
     */
    public void resetGCState() {
        gcCanvas.resetGCState();
    }

    /** 
     * 执行
     * @param evt
     * @param arg
     * @return
     * @see java.awt.Component#action(java.awt.Event, java.lang.Object)
     */
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Button) {
            String bname = (String) arg;
            if (bname.equals(HeapOfFishStrings.step)) {
                gcCanvas.nextGCStep();
                gcCanvas.repaint();
            } else if (bname.equals(HeapOfFishStrings.reset)) {
                gcCanvas.resetGCState();
                gcCanvas.repaint();
            }
        }
        return true;
    }
}
