/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 鱼堆模型复选框
 * @author wxh
 * @version $Id: HeapOfFishModeCheckboxPanel.java, v 0.1 2017年12月19日 下午4:43:48 wxh Exp $
 */
public class HeapOfFishModeCheckboxPanel extends Panel {

    /** */
    private static final long serialVersionUID = -1343361561097375344L;

    private CheckboxGroup     cbg              = new CheckboxGroup();

    /**
     * 在构造方法初始化参数
     */
    public HeapOfFishModeCheckboxPanel() {

        setBackground(Color.lightGray);

        setLayout(new GridLayout(5, 1));
        add(new Checkbox(HeapOfFishStrings.allocateFish, cbg, false));
        add(new Checkbox(HeapOfFishStrings.assignReferences, cbg, false));
        add(new Checkbox(HeapOfFishStrings.garbageCollect, cbg, false));
        add(new Checkbox(HeapOfFishStrings.compactHeap, cbg, false));
        add(new Checkbox(HeapOfFishStrings.swim, cbg, true));
    }

    /**
     * 获取复选框组
     * @return
     */
    public CheckboxGroup getModeCheckboxGroup() {
        return cbg;
    }
}
