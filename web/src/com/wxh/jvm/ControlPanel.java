/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Panel;

/**
 * 获取一个类加载器
 * @author wxh
 * @version $Id: ControlPanel.java, v 0.1 2017年12月19日 上午10:43:13 wxh Exp $
 */
public class ControlPanel extends Panel {

    /** */
    private static final long serialVersionUID = -371405562959850655L;

    private JVMPacman         jvmPacman        = new JVMPacman();

    /**
     *  构造一个控制器面板
     */
    public ControlPanel() {
        // 设置为边界布局，北、南、东、西、中--NORTH、SOUTH、EAST、WEST、CENTER
        setLayout(new BorderLayout(5, 5));
        // 设置背景颜色为蓝色
        setBackground(Color.blue);
        // 控制器面板西部放置一个按钮面板
        add("West", new ButtonPanel());
        // 控制器面板中部放置一个按钮面板
        add("Center", jvmPacman);
    }

    /**
     * 
     * @return
     */
    public JVMPacman getJVMPacman() {
        return jvmPacman;
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
