/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 双向链表结点定义--double linked list
 * 结点：前驱指针域、数据域、后继指针域
 * @author wxh
 * @version $Id: DLNode.java, v 0.1 2017年11月21日 上午10:53:21 wxh Exp $
 */
public class DLNode implements Node {

    /**前驱指针域 */
    private DLNode prev;
    /** 数据域  */
    private Object element;
    /** 后继指针域  */
    private DLNode next;

    /**
     * 空对象构造方法
     */
    public DLNode() {
        this(null, null, null);
    }

    /**
     * 
     */
    public DLNode(DLNode prev, Object obj, DLNode next) {
        this.prev = prev;
        this.element = obj;
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
     * @param obj
     */
    @Override
    public void setData(Object obj) {
        this.element = obj;
    }

    public DLNode getPrev() {
        return prev;
    }

    public void setPrev(DLNode prev) {
        this.prev = prev;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }
}
