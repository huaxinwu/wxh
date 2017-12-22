/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Event;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 设置引用面板
 * @author wxh
 * @version $Id: AssignReferencesPanel.java, v 0.1 2017年12月19日 下午4:13:46 wxh Exp $
 */
public class AssignReferencesPanel extends Panel {

    /** */
    private static final long        serialVersionUID      = -7575207848913541310L;
    private HeapOfFishTextArea       controlPanelTextArea;
    /** 当前设置引用的模式为连接鱼模式  */
    private String                   currentAssignRefsMode = HeapOfFishStrings.linkFish;

    /** 有多个设置引用的面板   */
    private AssignReferencesCanvases assignRefsCanvases;

    /**
     * 在构造方法中初始化参数
     * @param gcHeap
     * @param localVars
     * @param ta
     */
    public AssignReferencesPanel(GCHeap gcHeap, LocalVariables localVars, HeapOfFishTextArea text) {

        controlPanelTextArea = text;
        setBackground(Color.blue);
        // 设置为边界布局
        setLayout(new BorderLayout());
        // 创建有多个设置引用的面板类实例化
        assignRefsCanvases = new AssignReferencesCanvases(gcHeap, localVars, text);

        add("South", new AssignReferencesCheckboxPanel());
        add("Center", assignRefsCanvases);
    }

    /**
     * 刷新指令
     */
    public void refreshInstructions() {
        if (currentAssignRefsMode.equals(HeapOfFishStrings.moveFish)) {
            controlPanelTextArea.setText(HeapOfFishStrings.moveFishInstructions);
        } else if (currentAssignRefsMode.equals(HeapOfFishStrings.linkFish)) {
            controlPanelTextArea.setText(HeapOfFishStrings.linkFishInstructions);
        } else if (currentAssignRefsMode.equals(HeapOfFishStrings.unlinkFish)) {
            controlPanelTextArea.setText(HeapOfFishStrings.unlinkFishInstructions);
        }
    }

    /** 
     * 执行
     * @param evt
     * @param arg
     * @return
     * @see java.awt.Component#action(java.awt.Event, java.lang.Object)
     */
    public boolean action(Event evt, Object arg) {
        // 如果事件目标是复选框的实例，进行相关设置
        if (evt.target instanceof Checkbox) {
            Checkbox cb = (Checkbox) evt.target;
            // 获取复选框的名称
            String cbname = cb.getLabel();
            // 如果复选框名称是移动鱼，进行相关设置
            if (cbname.equals(HeapOfFishStrings.moveFish)) {
                if (!currentAssignRefsMode.equals(HeapOfFishStrings.moveFish)) {
                    controlPanelTextArea.setText(HeapOfFishStrings.moveFish);
                    assignRefsCanvases.setMode(HeapOfFishStrings.moveFish);
                    controlPanelTextArea.setText(HeapOfFishStrings.moveFishInstructions);
                }
            } else if (cbname.equals(HeapOfFishStrings.linkFish)) {
                if (!currentAssignRefsMode.equals(HeapOfFishStrings.linkFish)) {
                    controlPanelTextArea.setText(HeapOfFishStrings.linkFish);
                    assignRefsCanvases.setMode(HeapOfFishStrings.linkFish);
                    controlPanelTextArea.setText(HeapOfFishStrings.linkFishInstructions);
                }
            } else if (cbname.equals(HeapOfFishStrings.unlinkFish)) {
                if (!currentAssignRefsMode.equals(HeapOfFishStrings.unlinkFish)) {
                    controlPanelTextArea.setText(HeapOfFishStrings.unlinkFish);
                    assignRefsCanvases.setMode(HeapOfFishStrings.unlinkFish);
                    controlPanelTextArea.setText(HeapOfFishStrings.unlinkFishInstructions);
                }
            }
            // 设置当前设置引用模式为所选中的复选框名称
            currentAssignRefsMode = cbname;
        }
        return true;
    }
}
