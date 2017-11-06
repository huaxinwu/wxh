/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 模仿ArrayList实现自定义集合
 * 集合是基于对象数组实现的。
 * 扩容实现原理：就是每次都会先判断容量是不是在对象数组容量范围内，超出就通过自增后将数据拷贝到一个新数组，在把引用指向对象数组
 * @author wxh
 * @version $Id: SimpleList.java, v 0.1 2017年10月26日 下午4:08:47 wxh Exp $
 */
public class SimpleList<T> {

    /** 默认集合容量  */
    private static final int      DEFAULT_CAPACITY  = 10;
    /** 空数据 */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /** 用来记录集合中修改元素时候次数  */
    private int                   modCount          = 0;

    /** 存储集合中的元素  */
    private Object[]              elementData;
    /** 集合中元素的个数  */
    private int                   size;

    /**
     * 检查查找的索引是否在集合元素的容量范围内
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 删除指定索引的元素，移动其他元素位置
     * @param index
     */
    private void fastRemove(int index) {
        modCount++;
        // 数组元素索引的起始位置
        int numMove = size - index - 1;
        // 大于零，将数组元素拷贝到一个新数组中
        if (numMove > 0) {
            // Object src : 原数组
            // int srcPos : 从元数据的起始位置开始
            // Object dest : 目标数组
            // int destPos : 目标数组的开始起始位置
            // int length  : 要copy的数组的元素个数
            // 把从索引index + 1开始的numMove个数字复制到索引为index的位置上 
            System.arraycopy(elementData, index + 1, elementData, index, numMove);
        }
        // 让gc回收
        elementData[--size] = null;
    }

    /**
     *  空集合
     */
    public SimpleList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    /**
     * 指定容量的集合
     * @param capacity
     */
    public SimpleList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.elementData = new Object[capacity];
    }

    /**
     * 获取集合元素的个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断集合是否为空
     * 集合元素个数等于零
     * @return
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * 添加某个元素
     * 将元素存入数组的某个索引，同时元素个数加1
     * @param t
     * @return
     */
    public boolean add(T t) {
        elementData[size++] = t;
        return true;
    }

    /**
     * 删除某个元素
     * 先判断参数是否为空，如果为空，删除元素(ArrayList可以存入null)，将集合中元素位置变动，直接返回true
     * 如果不为空，删除元素后，将集合中元素位置变动，直接返回true
     * 
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            // 遍历集合，找出集合中为null的元素删除并移动其他元素位置
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    // 删除元素，移动其他元素位置
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    // 如果找到删除移动元素位置
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据集合下标获取对应的元素
     * 首先要对索引进行范围检查，不在该范围直接抛出角标越界，否则直接通过集合下标获取元素
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return (T) elementData[index];
    }

}
