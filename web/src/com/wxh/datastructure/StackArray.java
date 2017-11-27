/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 顺序存储实现栈：对象数组实现栈
 * @author wxh
 * @version $Id: StackArray.java, v 0.1 2017年11月22日 下午4:31:55 wxh Exp $
 */
public class StackArray implements Stack {

    /** 数组默认大小  */
    private final int len = 8;
    /** 数据元素数组  */
    private Object[]  elements;
    /** 栈顶指针  */
    private int       top;

    /**
     * 扩展空间
     */
    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    /**
     * 
     */
    public StackArray() {
        this.top = -1;
        elements = new Object[len];
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Stack#getSize()
     */
    @Override
    public int getSize() {
        return this.top + 1;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Stack#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.top < 0;
    }

    /** 
     * @param o
     * @see com.wxh.datastructure.Stack#push(java.lang.Object)
     */
    @Override
    public void push(Object o) {
        if (getSize() > elements.length) {
            // 扩容
            expandSpace();
        }
        // 将数据元素赋值给对应栈顶的数据元素
        elements[++top] = o;
    }

    /** 
     * @return
     * @throws StackEmptyException
     * @see com.wxh.datastructure.Stack#pop()
     */
    @Override
    public Object pop() throws StackEmptyException {
        if (getSize() < 1) {
            throw new StackEmptyException("栈为空");
        }
        // 取出栈顶数据元素
        Object object = elements[top];
        elements[top--] = null;
        return object;
    }

    /** 
     * @return
     * @throws StackEmptyException
     * @see com.wxh.datastructure.Stack#peek()
     */
    @Override
    public Object peek() throws StackEmptyException {
        if (getSize() < 1) {
            throw new StackEmptyException("栈为空");
        }
        return elements[top];
    }

}
