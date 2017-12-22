/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Point;

/**
 * 一个模拟：垃圾收集堆
 * 本地变量
 * @author wxh
 * @version $Id: LocalVariables.java, v 0.1 2017年12月19日 下午4:50:25 wxh Exp $
 */
public class LocalVariables {

    /** 黄色鱼位置  */
    public int   yellowFish;
    /** 蓝色鱼 位置 */
    public int   blueFish;
    /** 红色鱼位置   */
    public int   redFish;

    /** 黄色线条的起点  */
    public Point yellowLineStart;
    /** 黄色线条的终点  */
    public Point yellowLineEnd;

    public Point blueLineStart;
    public Point blueLineEnd;

    public Point redLineStart;
    public Point redLineEnd;
}
