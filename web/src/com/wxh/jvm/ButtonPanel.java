/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

/**
 * 获取一个类加载器
 * 按钮面板
 * @author wxh
 * @version $Id: ButtonPanel.java, v 0.1 2017年12月19日 上午10:21:34 wxh Exp $
 */
public class ButtonPanel extends Panel {

    /** */
    private static final long serialVersionUID = -699606215133544191L;

    /**
     *  构造一个按钮面板
     */
    public ButtonPanel() {
        // 设置为网格布局
        setLayout(new GridLayout(3, 1, 5, 5));
        // 设置面板背景颜色--蓝色
        setBackground(Color.blue);
        Button button = new Button("Step");
        // 设置按钮背景颜色--浅灰色
        button.setBackground(Color.lightGray);
        // 将按钮添加到面板上
        add(button);
        // 在创建两个按钮设置其背景颜色，并添加到面板上
        button = new Button("Back");
        button.setBackground(Color.lightGray);
        add(button);
        button = new Button("Reset");
        button.setBackground(Color.lightGray);
        add(button);
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

}
