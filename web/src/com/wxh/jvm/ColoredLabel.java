/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

/**
 * 获取一个类加载器
 * 彩色标签面板
 * @author wxh
 * @version $Id: ColoredLabel.java, v 0.1 2017年12月19日 上午10:35:23 wxh Exp $
 */
public class ColoredLabel extends Panel {

    /** */
    private static final long serialVersionUID = -4882545302029356988L;

    private Label             theLabel;

    /**
     * 构造一个彩色标签面板
     * @param label
     * @param alignment
     * @param color
     */
    public ColoredLabel(String label, int alignment, Color color) {
        // 设置为网格布局
        setLayout(new GridLayout(1, 1));
        setBackground(color);
        // 创建一个标签对象
        theLabel = new Label(label, alignment);
        // 将标签添加到面板上
        add(theLabel);
    }

    /** 
     * 获取一个插图
     * @return
     * @see java.awt.Container#insets()
     */
    public Insets insets() {
        // top, left, bottom, right  
        // 从面板上的左上角原点开始
        return new Insets(0, 0, 0, 0);
    }

    /**
     * 设置标签的文本内容
     * @param s
     */
    public void setLabelText(String s) {
        theLabel.setText(s);
    }

}
