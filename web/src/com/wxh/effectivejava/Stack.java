/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.EmptyStackException;

/**
 * 内存管理，垃圾回收 hotspot gc
 * 栈→栈帧组成，栈帧有操作数帧，压栈、出栈操作
 * 内存泄漏：指程序中间动态分配了内存，但在程序结束时没有释放这部分内存，从而造成那部分内存不可用的情况
 * 内存溢出：指程序在申请内存时，没有足够的内存空间供其使用，出现out of memory
 * @author wxh
 * @version $Id: Stack.java, v 0.1 2017年9月5日 下午2:27:28 wxh Exp $
 */
public class Stack {

    private Object[] elements;
    private int      size = 0;

    /**
     * 确保容量空间充足
     * 扩充容量
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[2 * elements.length + 1];
            // 数组拷贝 ，Arrays.copyOf
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }

    /**
     * @param initialCapacity 初始容量
     */
    public Stack(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    /**
     * 压栈
     * @param object
     */
    public void push(Object object) {
        ensureCapacity();
        elements[size++] = object;
    }

    /**
     * 出栈
     * 出栈的对象不能被垃圾回收器回收，容易造成内存泄漏(memary leak)
     * 堆积过多造成内存溢出(oom-- out of memary)
     * 修复这个问题只需要弱引用，GC回收
     */
    public Object pop() {
        if (size == 0) {
            // 空栈异常
            throw new EmptyStackException();
        }
        // 弱引用
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * 递归调用
     * @return
     * @throws CloneNotSupportedException
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Stack result = (Stack) super.clone();
        result.elements = (Object[]) elements.clone();
        return result;
    }
}
