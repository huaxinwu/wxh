/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.GridLayout;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 分配鱼按钮面板
 * @author wxh
 * @version $Id: AllocateFishButtonPanel.java, v 0.1 2017年12月19日 下午3:53:39 wxh Exp $
 */
public class AllocateFishButtonPanel extends Panel {

    /** */
    private static final long serialVersionUID = 3926160231471238102L;

    /**
     * 在分配鱼面板添加红色鱼面板、蓝色鱼面板、黄色鱼面板
     */
    public AllocateFishButtonPanel() {
        // 设置为网格布局,1行3列
        setLayout(new GridLayout(1, 3));
        // 添加红色鱼按钮面板、蓝色鱼按钮面板、黄色鱼按钮面板
        add(new RedFishButtonPanel());
        add(new BlueFishButtonPanel());
        add(new YellowFishButtonPanel());
    }

}
