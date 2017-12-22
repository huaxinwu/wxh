/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.CardLayout;
import java.awt.Panel;

/**
 *  一个模拟：垃圾收集堆
 *  有多个的设置引用面板
 * @author wxh
 * @version $Id: AssignReferencesCanvases.java, v 0.1 2017年12月19日 下午4:16:17 wxh Exp $
 */
public class AssignReferencesCanvases extends Panel {

    /** */
    private static final long serialVersionUID = 7435167414780000508L;
    /** 卡片布局  */
    private CardLayout        cl               = new CardLayout();
    /** 当前模式为连接鱼模式   */
    private String            currentMode      = HeapOfFishStrings.linkFish;

    /**
     * 在构造方法中初始化参数
     * @param gcHeap
     * @param localVars
     * @param ta
     */
    public AssignReferencesCanvases(GCHeap gcHeap, LocalVariables localVars, HeapOfFishTextArea ta) {
        // 设置为卡片布局
        setLayout(cl);
        // 移动
        add(HeapOfFishStrings.moveFish, new MoveFishCanvas(gcHeap, localVars, ta));
        // 连接 
        add(HeapOfFishStrings.linkFish, new LinkFishCanvas(gcHeap, localVars, ta));
        // 断开
        add(HeapOfFishStrings.unlinkFish, new UnlinkFishCanvas(gcHeap, localVars, ta));
        cl.show(this, currentMode);
    }

    /**
     * 设置模式
     * @param mode
     */
    public void setMode(String mode) {
        cl.show(this, mode);
        currentMode = mode;
    }
}
