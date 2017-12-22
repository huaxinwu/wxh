/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 设置引用复选框面板
 * @author wxh
 * @version $Id: AssignReferencesCheckboxPanel.java, v 0.1 2017年12月19日 下午4:12:18 wxh Exp $
 */
public class AssignReferencesCheckboxPanel extends Panel {

    /** */
    private static final long serialVersionUID = -8140036733308347236L;

    /** 复选框组  */
    private CheckboxGroup     cbg              = new CheckboxGroup();

    /**
     * 在构造方法中初始化参数
     */
    public AssignReferencesCheckboxPanel() {
        setBackground(Color.lightGray);
        // 设置为网格布局
        setLayout(new GridLayout(1, 3));

        Panel p = new Panel();
        // 设置为流式布局，从原点从左到右依次排列下来
        p.setLayout(new FlowLayout());
        p.add(new Checkbox(HeapOfFishStrings.moveFish, cbg, false));
        // 将面板p添加到设置引用复选框面板上
        add(p);

        p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(new Checkbox(HeapOfFishStrings.linkFish, cbg, true));
        add(p);

        p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(new Checkbox(HeapOfFishStrings.unlinkFish, cbg, false));
        add(p);
    }
}
