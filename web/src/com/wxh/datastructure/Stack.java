/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 栈接口
 * 栈：栈顶和栈底
 * @author wxh
 * @version $Id: Stack.java, v 0.1 2017年11月22日 下午4:19:40 wxh Exp $
 */
public interface Stack {

    /**
     * 获取栈的数据元素个数
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 将数据元素入栈
     * @param o
     */
    void push(Object o);

    /**
     * 栈顶元素出栈
     */
    Object pop() throws StackEmptyException;

    /**
     * 获取栈顶元素
     */
    Object peek() throws StackEmptyException;

}
