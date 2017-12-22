/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 获取一个类加载器
 * 步结点
 * @author wxh
 * @version $Id: StepNode.java, v 0.1 2017年12月19日 上午11:00:54 wxh Exp $
 */
public class StepNode {

    private String   theString;
    /** 下一个结点  */
    private StepNode next;
    /** 上一个结点  */
    private StepNode prev;
    /** 默认下一个结点无效  */
    private boolean  nextValid = false;
    /** 默认上一个结点无效  */
    private boolean  prevValid = false;
    private int      byteCount = 0;

    /**
     * 初始化字符串变量，字节数量
     * @param s
     * @param bytes
     */
    public StepNode(String s, int bytes) {
        theString = s;
        byteCount = bytes;
    }

    /**
     * 获取一个字符串
     * @return
     */
    public String getString() {
        return theString;
    }

    /**
     * 获取字节数量
     * @return
     */
    public int getByteCount() {
        return byteCount;
    }

    /**
     * 获取下一个结点
     * @return
     */
    public StepNode getNext() {
        return next;
    }

    /**
     * 设置下一个结点
     * @param n
     */
    public void setNext(StepNode n) {
        next = n;
        nextValid = true;
    }

    /**
     * 获取上一个结点
     * @return
     */
    public StepNode getPrev() {
        return prev;
    }

    /**
     * 设置上一个结点
     * @param n
     */
    public void setPrev(StepNode n) {
        prev = n;
        prevValid = true;
    }

    /**
     * 获取第一个结点
     * @return
     */
    public boolean first() {
        return !prevValid;
    }

    /**
     * 获取最后一个结点
     * @return
     */
    public boolean last() {
        return !nextValid;
    }

}
