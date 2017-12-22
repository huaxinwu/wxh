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
 * 分配鱼面板
 * @author wxh
 * @version $Id: AllocateFishPanel.java, v 0.1 2017年12月19日 下午3:58:58 wxh Exp $
 */
public class AllocateFishPanel extends Panel {

    /** */
    private static final long  serialVersionUID = 951585677882614062L;

    /** GC堆对象  */
    private GCHeap             gcHeap;
    /** 鱼堆的文本域  */
    private HeapOfFishTextArea controlPanelTextArea;
    /** 池的画布 */
    private PoolsCanvas        poolsCanvas;

    /**
     *  初始化分配鱼面板参数
     * @param heap
     * @param ta
     */
    public AllocateFishPanel(GCHeap heap, HeapOfFishTextArea text) {
        gcHeap = heap;
        controlPanelTextArea = text;
        setBackground(Color.blue);
        setLayout(new BorderLayout());
        // 设置为边界布局，在南部添加一个分配鱼按钮面板、在中部添加一个池的画布
        poolsCanvas = new PoolsCanvas(gcHeap);
        add("South", new AllocateFishButtonPanel());
        add("Center", poolsCanvas);
    }

    /** 
     * 执行
     * @param evt
     * @param arg
     * @return
     * @see java.awt.Component#action(java.awt.Event, java.lang.Object)
     */
    public boolean action(Event evt, Object arg) {
        // 如果事件目标是按钮实例，设置相关参数
        if (evt.target instanceof Button) {
            // 事件目标的名称
            String bname = (String) arg;
            // 获取维度
            //            Dimension canvasDim = poolsCanvas.size();
            // 如果名称是一个新的红色鱼，绘制鱼及图标等等
            if (bname.equals(HeapOfFishStrings.newRedFish)) {
                // 设置不是大红色鱼图标的鱼图标
                FishIcon fish = new BigRedFishIcon(false);
                // GC堆给鱼图标分配对象，划分个数
                int newFish = gcHeap.allocateObject(12, fish);
                if (newFish > 0) {
                    // 对象处理事件
                    ObjectHandle oh = gcHeap.getObjectHandle(newFish);
                    // 设置对象池数据
                    gcHeap.setObjectPool(oh.objectPos, 0);
                    gcHeap.setObjectPool(oh.objectPos + 1, 0);
                    gcHeap.setObjectPool(oh.objectPos + 2, 0);
                    // 设置文本域内容为新的红色鱼已经分配成功
                    controlPanelTextArea.setText(HeapOfFishStrings.newRedFishAllocated);
                } else {
                    controlPanelTextArea.setText(HeapOfFishStrings.newRedFishNotAllocated);
                }
                // 重新绘制图
                poolsCanvas.repaint();
            } else if (bname.equals(HeapOfFishStrings.newBlueFish)) {
                // 如果事件目标名称是一个新的蓝色鱼，进行相关设置
                FishIcon fish = new MediumBlueFishIcon(false);
                // 分配8个字节长度
                int newFish = gcHeap.allocateObject(8, fish);
                if (newFish > 0) {
                    ObjectHandle oh = gcHeap.getObjectHandle(newFish);
                    gcHeap.setObjectPool(oh.objectPos, 0);
                    gcHeap.setObjectPool(oh.objectPos + 1, 0);
                    controlPanelTextArea.setText(HeapOfFishStrings.newBlueFishAllocated);
                } else {
                    controlPanelTextArea.setText(HeapOfFishStrings.newBlueFishNotAllocated);
                }
                poolsCanvas.repaint();
            } else if (bname.equals(HeapOfFishStrings.newYellowFish)) {
                // 如果事件目标名称是一个新的黄色鱼，进行相关设置
                FishIcon fish = new LittleYellowFishIcon(false);
                int newFish = gcHeap.allocateObject(4, fish);
                if (newFish > 0) {
                    ObjectHandle oh = gcHeap.getObjectHandle(newFish);
                    gcHeap.setObjectPool(oh.objectPos, 0);
                    controlPanelTextArea.setText(HeapOfFishStrings.newYellowFishAllocated);
                } else {
                    controlPanelTextArea.setText(HeapOfFishStrings.newYellowFishNotAllocated);
                }
                poolsCanvas.repaint();
            }
        }
        return true;
    }
}
