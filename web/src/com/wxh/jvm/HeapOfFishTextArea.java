/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.TextArea;

/**
 * 一个模拟：垃圾收集堆
 * 鱼堆文本域
 * @author wxh
 * @version $Id: HeapOfFishTextArea.java, v 0.1 2017年12月19日 下午4:01:07 wxh Exp $
 */
public class HeapOfFishTextArea extends TextArea {
    /** */
    private static final long serialVersionUID = 3048059280315797209L;

    /**
     * 在构造方法初始化参数
     */
    public HeapOfFishTextArea() {
        setBackground(Color.white);
        setEditable(false);
    }
}
