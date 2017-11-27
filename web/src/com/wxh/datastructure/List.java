/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 线性表抽象数据类型
 * @author wxh
 * @version $Id: List.java, v 0.1 2017年11月20日 下午2:55:47 wxh Exp $
 */
public interface List {

    /**
     * 线性表的大小
     * @return
     */
    int getSize();

    /**
     * 判断线性表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断线性表是否包含某个元素
     * @param o
     * @return
     */
    boolean contains(Object o);

    /**
     * 查找某个元素在线性表的索引
     * @param o
     * @return
     */
    int indexOf(Object o);

    /**
     * 在线性表指定位置插入一个元素
     * @param i
     * @param o
     * @throws OutOfBoundsException
     */
    void insert(int i, Object o) throws OutOfBoundsException;

    /**
     * 在线性表某个元素之前插入一个元素
     * @param obj
     * @param o
     * @return
     */
    boolean insertBefore(Object obj, Object o);

    /**
     * 在线性表某个元素之后插入一个元素
     * @param obj
     * @param o
     * @return
     */
    boolean insertAfter(Object obj, Object o);

    /**
     * 删除线性表指定位置的元素
     * @param i
     * @return
     * @throws OutOfBoundsException
     */
    Object remove(int i) throws OutOfBoundsException;

    /**
     * 删除线性表某个元素
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 替换线性表指定位置的元素
     * @param i
     * @param o
     * @return
     * @throws OutOfBoundsException
     */
    Object replace(int i, Object o) throws OutOfBoundsException;

    /**
     * 获取线性表指定位置的元素
     * @param i
     * @return
     * @throws OutOfBoundsException
     */
    Object get(int i) throws OutOfBoundsException;

}
