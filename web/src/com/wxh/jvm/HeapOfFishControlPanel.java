/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 鱼堆控制面板
 * @author wxh
 * @version $Id: HeapOfFishControlPanel.java, v 0.1 2017年12月19日 下午4:42:04 wxh Exp $
 */
public class HeapOfFishControlPanel extends Panel {

    /** */
    private static final long           serialVersionUID  = -2835865642838556732L;

    private HeapOfFishModeCheckboxPanel modeCheckboxPanel = new HeapOfFishModeCheckboxPanel();
    private HeapOfFishTextArea          text              = new HeapOfFishTextArea();

    /**
     * 在构造方法初始化参数
     */
    public HeapOfFishControlPanel() {

        setBackground(Color.lightGray);

        setLayout(new BorderLayout());
        add("West", modeCheckboxPanel);
        add("Center", text);
    }

    /**
     * 获取复选框组
     * @return
     */
    public CheckboxGroup getModeCheckboxGroup() {
        return modeCheckboxPanel.getModeCheckboxGroup();
    }

    /**
     * 获取文本域
     * @return
     */
    public HeapOfFishTextArea getTextArea() {
        return text;
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
     * 获取维度最小值
     * @return
     * @see java.awt.Container#minimumSize()
     */
    public Dimension minimumSize() {
        return new Dimension(500, 90);
    }

    /** 
     * 获取维度首选值
     * @return
     * @see java.awt.Container#preferredSize()
     */
    public Dimension preferredSize() {
        return new Dimension(500, 90);
    }

}
