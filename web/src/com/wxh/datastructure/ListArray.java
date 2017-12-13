/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 数组实现线性表
 * @author wxh
 * @version $Id: ListArray.java, v 0.1 2017年11月20日 下午3:37:40 wxh Exp $
 */
public class ListArray implements List {

    /** 数组的默认大小  */
    private final int length = 8;
    private Strategy  strategy;
    /** 线性表的数据元素个数   */
    private int       size;
    private Object[]  elements;

    /**
     * 拓展空间
     */
    private void expandSpace() {
        // 在原来的基础上扩大一倍
        Object[] objects = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            // 把原数组的元素拷贝到新数组
            objects[i] = elements[i];
        }
        // 将新数组赋值给原数组,完成扩容
        elements = objects;
    }

    public ListArray() {
    }

    /**
     * 初始化数据
     */
    public ListArray(Strategy strategy) {
        this.strategy = strategy;
        size = 0;
        elements = new Object[length];
    }

    /** 
     * 获取线性表的数据元素个数
     * @return
     * @see com.wxh.datastructure.List#getSize()
     */
    @Override
    public int getSize() {
        return size;
    }

    /** 
     * 判断线性表是否为空
     * @return
     * @see com.wxh.datastructure.List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** 
     * 判断线性表包含某个数据元素
     * @param o
     * @return
     * @see com.wxh.datastructure.List#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            // 比较两个对象是否相等
            if (strategy.equals(o, elements[i])) {
                return true;
            }
        }
        return false;
    }

    /** 
     * 查找某个数据元素的索引
     * @param o
     * @return
     * @see com.wxh.datastructure.List#indexOf(java.lang.Object)
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (strategy.equals(o, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /** 
     * 在指定位置插入一个数据元素
     * @param i
     * @param o
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#insert(int, java.lang.Object)
     */
    @Override
    public void insert(int i, Object o) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        // 需要扩容，扩大对象数组的大小
        if (size >= elements.length) {
            expandSpace();
        }
        for (int j = size; j > i; j--) {
            // 将指定位置后面的元素向后移动一个位置
            elements[j] = elements[j - 1];
        }
        elements[i] = o;
        size++;
    }

    /** 
     * 在某个数据元素之前插入一个数据元素
     * @param obj
     * @param o
     * @return
     * @see com.wxh.datastructure.List#insertBefore(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean insertBefore(Object obj, Object o) {
        // 找到被插入元素的位置
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        // 插入元素
        insert(i, o);
        return true;
    }

    /** 
     * 在某个数据元素之后插入一个数据元素
     * @param obj
     * @param o
     * @return
     * @see com.wxh.datastructure.List#insertAfter(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean insertAfter(Object obj, Object o) {
        // 找到被插入元素的位置
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        // 再后面一个位置插入元素
        insert(i + 1, o);
        return true;
    }

    /** 
     * 删除指定位置的数据元素
     * @param i
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#remove(int)
     */
    @Override
    public Object remove(int i) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        // 找到指定位置的元素
        Object obj = elements[i];
        for (int j = i; j < size - 1; j++) {
            // 将后面的元素向前移动一个位置
            elements[j] = elements[j + 1];
        }
        // 移除位置的元素分配空间让gc回收
        elements[--size] = null;
        return obj;
    }

    /** 
     * 删除某个数据元素
     * @param o
     * @return
     * @see com.wxh.datastructure.List#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i < 0) {
            return false;
        }
        remove(i);
        return true;
    }

    /** 
     * 替换指定位置的某个数据元素
     * @param i
     * @param o
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#replace(int, java.lang.Object)
     */
    @Override
    public Object replace(int i, Object o) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        Object obj = elements[i];
        // 将新元素赋值给旧元素
        elements[i] = o;
        return obj;
    }

    /** 
     * 获取指定位置的数据元素
     * @param i
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#get(int)
     */
    @Override
    public Object get(int i) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        return elements[i];
    }

}
