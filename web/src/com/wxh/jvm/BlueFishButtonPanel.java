/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 蓝色鱼按钮面板
 * @author wxh
 * @version $Id: BlueFishButtonPanel.java, v 0.1 2017年12月19日 下午3:56:05 wxh Exp $
 */
public class BlueFishButtonPanel extends Panel {

    /** */
    private static final long serialVersionUID = 659879274054748280L;

    /**
     * 在构造方法中初始化参数
     */
    public BlueFishButtonPanel() {
        // 设置为边界布局
        setLayout(new BorderLayout());

        Button b = new Button(HeapOfFishStrings.newBlueFish);
        b.setBackground(Color.lightGray);
        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(b);

        add("South", p);
        add("Center", new BlueFishButtonCanvas());
    }
}
