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
 * 垃圾收集按钮面板
 * @author wxh
 * @version $Id: GarbageCollectButtonPanel.java, v 0.1 2017年12月19日 下午4:30:25 wxh Exp $
 */
public class GarbageCollectButtonPanel extends Panel {

    /** */
    private static final long serialVersionUID = -5081079603987417294L;

    /**
     * 在构造方法中初始化参数
     */
    public GarbageCollectButtonPanel() {

        setLayout(new GridLayout(1, 2));

        Panel p = new Panel();
        p.add(new Button(HeapOfFishStrings.step));
        add(p);

        p = new Panel();
        p.add(new Button(HeapOfFishStrings.reset));
        add(p);
    }
}
