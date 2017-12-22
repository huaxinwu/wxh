/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;

/**
 * 一个模拟：垃圾收集堆
 * 组件堆按钮面板
 * @author wxh
 * @version $Id: CompactHeapButtonPanel.java, v 0.1 2017年12月19日 下午4:23:59 wxh Exp $
 */
public class CompactHeapButtonPanel extends Panel {

    /** */
    private static final long serialVersionUID = -2587113867011381275L;

    /**
     * 构造一个组件堆按钮面板
     */
    public CompactHeapButtonPanel() {
        // 设置为边界布局
        setLayout(new GridLayout(1, 1));
        Panel p = new Panel();
        p.add(new Button(HeapOfFishStrings.slide));
        add(p);
    }
}
