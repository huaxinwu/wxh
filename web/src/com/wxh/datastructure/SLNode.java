/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 单链表结点定义--single linked list
 * 结点：数据域、指针域
 * @author wxh
 * @version $Id: SLNode.java, v 0.1 2017年11月21日 上午10:24:49 wxh Exp $
 */
public class SLNode implements Node {

    /** 数据域  */
    private Object element;

    /** 指针域  */
    private SLNode next;

    /**
     * 空对象构造方法
     */
    public SLNode() {
        this(null, null);
    }

    /**
     * @param ele
     * @param next
     */
    public SLNode(Object ele, SLNode next) {
        this.element = ele;
        this.next = next;
    }

    /** 
     * @return
     */
    @Override
    public Object getData() {
        return element;
    }

    /** 
     * @param ojb
     */
    @Override
    public void setData(Object obj) {
        // 传入的参数赋值给数据域的对象
        this.element = obj;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

}
