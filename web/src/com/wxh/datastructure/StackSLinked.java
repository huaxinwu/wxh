/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 链式存储实现栈：单链表实现栈
 * @author wxh
 * @version $Id: StackSLinked.java, v 0.1 2017年11月22日 下午4:53:50 wxh Exp $
 */
public class StackSLinked implements Stack {

    /** 单链表首结点引用  */
    private SLNode top;
    /** 栈的大小  */
    private int    size;

    /**
     * 
     */
    public StackSLinked() {
        top = null;
        size = 0;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Stack#getSize()
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Stack#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** 
     * @param o
     * @see com.wxh.datastructure.Stack#push(java.lang.Object)
     */
    @Override
    public void push(Object o) {
        // 创建一个单链表结点
        SLNode q = new SLNode(o, top);
        // 赋值
        top = q;
        size++;
    }

    /** 
     * @return
     * @throws StackEmptyException
     * @see com.wxh.datastructure.Stack#pop()
     */
    @Override
    public Object pop() throws StackEmptyException {
        if (size < 1) {
            throw new StackEmptyException("栈为空");
        }
        Object obj = top.getData();
        // 结点下移一位
        top = top.getNext();
        size--;
        return obj;
    }

    /** 
     * @return
     * @throws StackEmptyException
     * @see com.wxh.datastructure.Stack#peek()
     */
    @Override
    public Object peek() throws StackEmptyException {
        if (size < 1) {
            throw new StackEmptyException("栈为空");
        }
        return top.getData();
    }

}
