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
 * 组件堆面板
 * @author wxh
 * @version $Id: CompactHeapPanel.java, v 0.1 2017年12月19日 下午4:26:55 wxh Exp $
 */
public class CompactHeapPanel extends Panel {

    /** */
    private static final long  serialVersionUID = -2246797177278972756L;

    private GCHeap             gcHeap;
    private HeapOfFishTextArea controlPanelTextArea;

    private CompactHeapCanvas  compactHeapCanvas;

    /**
     * 在构造方法中初始化参数
     * @param heap
     * @param ta
     */
    public CompactHeapPanel(GCHeap heap, HeapOfFishTextArea ta) {

        gcHeap = heap;
        controlPanelTextArea = ta;

        setBackground(Color.blue);

        setLayout(new BorderLayout());

        compactHeapCanvas = new CompactHeapCanvas(gcHeap);

        add("South", new CompactHeapButtonPanel());
        add("Center", compactHeapCanvas);
    }

    /** 
     * 执行
     * @param evt
     * @param arg
     * @return
     * @see java.awt.Component#action(java.awt.Event, java.lang.Object)
     */
    public boolean action(Event evt, Object arg) {
        // 如果事件目标是按钮实例，进行相关设置
        if (evt.target instanceof Button) {
            String bname = (String) arg;
            if (bname.equals(HeapOfFishStrings.slide)) {
                boolean objectWasSlid = gcHeap.slideNextNonContiguousObjectDown();
                if (objectWasSlid) {
                    // 滑动成功
                    controlPanelTextArea.setText(HeapOfFishStrings.slidSuccessfully);
                } else {
                    // 不能再滑动了
                    controlPanelTextArea.setText(HeapOfFishStrings.cantSlideAnymore);
                }
                compactHeapCanvas.repaint();
            }
        }
        return true;
    }
}
