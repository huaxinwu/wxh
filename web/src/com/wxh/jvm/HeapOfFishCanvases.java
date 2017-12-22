/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.CardLayout;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 鱼堆画布
 * @author wxh
 * @version $Id: HeapOfFishCanvases.java, v 0.1 2017年12月19日 下午4:40:41 wxh Exp $
 */
public class HeapOfFishCanvases extends Panel {

    /** */
    private static final long     serialVersionUID = -2132845045284950759L;

    private CardLayout            cl               = new CardLayout();
    private SwimmingFishCanvas    swimmers         = new SwimmingFishCanvas();
    private String                currentMode      = HeapOfFishStrings.swim;
    private AssignReferencesPanel assignRefsPanel;
    private GarbageCollectPanel   garbageCollectPanel;

    /**
     * 在构造方法初始化参数
     * @param gcHeap
     * @param localVars
     * @param ta
     */
    public HeapOfFishCanvases(GCHeap gcHeap, LocalVariables localVars, HeapOfFishTextArea ta) {

        assignRefsPanel = new AssignReferencesPanel(gcHeap, localVars, ta);
        garbageCollectPanel = new GarbageCollectPanel(gcHeap, localVars, ta);
        setLayout(cl);
        add(HeapOfFishStrings.allocateFish, new AllocateFishPanel(gcHeap, ta));
        add(HeapOfFishStrings.assignReferences, assignRefsPanel);
        add(HeapOfFishStrings.garbageCollect, garbageCollectPanel);
        add(HeapOfFishStrings.compactHeap, new CompactHeapPanel(gcHeap, ta));
        add(HeapOfFishStrings.swim, swimmers);
        swimmers.start();
        cl.show(this, HeapOfFishStrings.swim);
    }

    /**
     * 设置模式
     * @param mode
     */
    public void setMode(String mode) {
        if (mode.equals(HeapOfFishStrings.garbageCollect)
            && !currentMode.equals(HeapOfFishStrings.garbageCollect)) {
            garbageCollectPanel.resetGCState();
        }
        cl.show(this, mode);
        if (mode.equals(HeapOfFishStrings.swim) && !currentMode.equals(HeapOfFishStrings.swim)) {
            swimmers.start();
        }
        if (!mode.equals(HeapOfFishStrings.swim) && currentMode.equals(HeapOfFishStrings.swim)) {
            swimmers.stop();
        }
        if (mode.equals(HeapOfFishStrings.assignReferences)
            && !currentMode.equals(HeapOfFishStrings.assignReferences)) {
            assignRefsPanel.refreshInstructions();
        }
        currentMode = mode;
    }

    /**
     * 启动
     */
    public void start() {
        swimmers.start();
    }

    /**
     * 停止
     */
    public void stop() {
        swimmers.stop();
    }
}
