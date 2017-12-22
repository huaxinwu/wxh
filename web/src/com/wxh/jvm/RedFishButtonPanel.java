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
 * 红色鱼按钮面板
 * @author wxh
 * @version $Id: RedFishButtonPanel.java, v 0.1 2017年12月19日 下午3:55:16 wxh Exp $
 */
public class RedFishButtonPanel extends Panel {

    /** */
    private static final long serialVersionUID = -2191090798162108017L;

    /**
     * 在构造方法初始化参数
     */
    public RedFishButtonPanel() {
        setLayout(new BorderLayout());
        Button b = new Button(HeapOfFishStrings.newRedFish);
        b.setBackground(Color.lightGray);
        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(b);
        add("South", p);
        add("Center", new RedFishButtonCanvas());
    }
}
