/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Event;
import java.awt.Insets;
import java.awt.Label;

/**
 * 一个模拟：垃圾收集堆
 * 建立鱼堆步骤:分配鱼、设置引用、垃圾收集、压缩堆
 * @author wxh
 * @version $Id: HeapOfFish.java, v 0.1 2017年12月19日 下午4:39:13 wxh Exp $
 */
public class HeapOfFish extends Applet {

    /** */
    private static final long      serialVersionUID      = -9157963692045610390L;
    private GCHeap                 gcHeap                = new GCHeap(15, 50);
    private LocalVariables         localVars             = new LocalVariables();

    private HeapOfFishControlPanel controlPanel          = new HeapOfFishControlPanel();
    private HeapOfFishCanvases     canvases              = new HeapOfFishCanvases(gcHeap,
                                                             localVars, controlPanel.getTextArea());
    private String                 currentHeapOfFishMode = HeapOfFishStrings.swim;

    /** 
     *  初始化参数
     * @see java.applet.Applet#init()
     */
    public void init() {
        super.init();
        setBackground(Color.cyan);

        setLayout(new BorderLayout(5, 5));
        add("North", new ColoredLabel("HEAP OF FISH", Label.CENTER, Color.white));
        add("South", controlPanel);
        add("Center", canvases);
    }

    /** 
     * 启动
     * @see java.applet.Applet#start()
     */
    public void start() {
        canvases.start();
    }

    /** 
     * 停止
     * @see java.applet.Applet#stop()
     */
    public void stop() {
        canvases.stop();
    }

    /** 
     * 插图
     * @return
     * @see java.awt.Container#insets()
     */
    public Insets insets() {
        return new Insets(5, 5, 5, 5);
    }

    /** 
     * 执行
     * @param evt
     * @param arg
     * @return
     * @see java.awt.Component#action(java.awt.Event, java.lang.Object)
     */
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Checkbox) {
            Checkbox cb = (Checkbox) evt.target;
            String cbname = cb.getLabel();
            if (cbname.equals(HeapOfFishStrings.allocateFish)) {
                if (!currentHeapOfFishMode.equals(HeapOfFishStrings.allocateFish)) {
                    controlPanel.getTextArea().setText(HeapOfFishStrings.allocateFishInstructions);
                    canvases.setMode(HeapOfFishStrings.allocateFish);
                }
            } else if (cbname.equals(HeapOfFishStrings.assignReferences)) {
                if (!currentHeapOfFishMode.equals(HeapOfFishStrings.assignReferences)) {
                    canvases.setMode(HeapOfFishStrings.assignReferences);
                }
            } else if (cbname.equals(HeapOfFishStrings.garbageCollect)) {
                if (!currentHeapOfFishMode.equals(HeapOfFishStrings.garbageCollect)) {
                    canvases.setMode(HeapOfFishStrings.garbageCollect);
                }
            } else if (cbname.equals(HeapOfFishStrings.compactHeap)) {
                if (!currentHeapOfFishMode.equals(HeapOfFishStrings.compactHeap)) {
                    controlPanel.getTextArea().setText(HeapOfFishStrings.compactHeapInstructions);
                    canvases.setMode(HeapOfFishStrings.compactHeap);
                }
            } else if (cbname.equals(HeapOfFishStrings.swim)) {
                if (!currentHeapOfFishMode.equals(HeapOfFishStrings.swim)) {
                    controlPanel.getTextArea().setText("");
                    canvases.setMode(HeapOfFishStrings.swim);
                }
            }
            currentHeapOfFishMode = cbname;
            canvases.repaint();
        }
        return true;
    }
}
