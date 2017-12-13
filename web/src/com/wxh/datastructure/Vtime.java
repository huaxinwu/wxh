/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 有向无环图的关键路径定义
 * @author wxh
 * @version $Id: Vtime.java, v 0.1 2017年12月6日 上午11:48:34 wxh Exp $
 */
public class Vtime {

    /** 最早开始时间   */
    private int ve;
    /** 最迟开始时间  */
    private int vl;

    /**
     * 初始化参数
     */
    public Vtime() {
        // 最迟开始时间为Integer的最大值
        this(0, Integer.MAX_VALUE);
    }

    public Vtime(int ve, int vl) {
        this.ve = ve;
        this.vl = vl;
    }

    /**
     * 获取最早开始时间
     * @return
     */
    public int getVE() {
        return ve;
    }

    /**
     * 获取最迟开始时间
     * @return
     */
    public int getVL() {
        return vl;
    }

    /**
     * 设置最早开始时间
     * @param t
     */
    public void setVE(int t) {
        this.ve = t;
    }

    /**
     * 设置最迟开始时间
     */
    public void setVL(int t) {
        this.vl = t;
    }

}
