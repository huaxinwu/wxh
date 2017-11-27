/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 基于LinkedList聚集对象的迭代器实现
 * @author wxh
 * @version $Id: LinkedListIterator.java, v 0.1 2017年11月22日 下午2:47:25 wxh Exp $
 */
public class LinkedListIterator implements Iterator {
    /** 链接表 */
    private LinkedList list;
    /** 当前结点  */
    private Node       current;

    /**
     * 初始化参数
     */
    public LinkedListIterator(LinkedList list) {
        this.list = list;
        // 如果链接表为空，当前结点为空，否则从链接表的第一个元素开始
        if (list.isEmpty()) {
            this.current = null;
        } else {
            this.current = list.first();
        }
    }

    /** 
     * 
     * @see com.wxh.datastructure.Iterator#first()
     */
    @Override
    public void first() {
        if (list.isEmpty()) {
            current = null;
        } else {
            current = list.first();
        }
    }

    /** 
     * 
     * @see com.wxh.datastructure.Iterator#next()
     */
    @Override
    public void next() {
        if (isDone()) {
            throw new OutOfBoundsException("已经没有元素可移动了");
        }
        // 是链接表最后一个结点--尾结点，指针域为null
        if (current == list.last()) {
            // 当前元素后面已经没有元素了
            current = null;
        } else {
            // 获取链接表的下一个结点
            current = list.getNext(current);
        }

    }

    /** 
     * @return
     * @see com.wxh.datastructure.Iterator#isDone()
     */
    @Override
    public boolean isDone() {
        // 如果当前结点为尾结点，表示没有可移动的元素了
        return current == null;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Iterator#currentItem()
     */
    @Override
    public Object currentItem() {
        // 判断当前结点是否为空
        if (isDone()) {
            throw new OutOfBoundsException("已经没有元素可移动了");
        }
        return current.getData();
    }

}
