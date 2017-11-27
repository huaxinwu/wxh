/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 链接表接口
 * 链接表是有一组结点序列以及基于结点操作的线性结构的抽象
 * @author wxh
 * @version $Id: LinkedList.java, v 0.1 2017年11月21日 下午4:05:38 wxh Exp $
 */
public interface LinkedList {
    /**
     * 链接表数据元素个数
     * @return
     */
    int getSize();

    /**
     * 判断链接表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 返回第一个结点
     * @return
     * @throws OutOfBoundsException
     */
    Node first() throws OutOfBoundsException;

    /**
     * 返回最后一个结点
     * @return
     * @throws OutOfBoundsException
     */
    Node last() throws OutOfBoundsException;

    /**
     * 获取p结点之后的结点
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws OutOfBoundsException
     */
    Node getNext(Node p) throws InvalidNodeException, OutOfBoundsException;

    /**
     * 获取p结点之前的结点
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws OutOfBoundsException
     */
    Node getPrev(Node p) throws InvalidNodeException, OutOfBoundsException;

    /**
     * 将o作为第一个元素插入链接表，并返回该元素所在结点
     * @param o
     * @return
     */
    Node insertFirst(Object o);

    /**
     * 将o作为最后一个元素插入链接表，并返回该元素所在结点
     * @param o
     * @return
     */
    Node insertLast(Object o);

    /**
     * 在p结点之后插入一个元素，并返回该元素所在结点
     * @param p
     * @param o
     * @return
     * @throws InvalidNodeException
     */
    Node insertAfter(Node p, Object o) throws InvalidNodeException;

    /**
     * 在p结点之前插入一个元素，并返回该元素所在结点
     * @param p
     * @param o
     * @return
     * @throws InvalidNodeException
     */
    Node insertBefore(Node p, Object o) throws InvalidNodeException;

    /**
     * 删除指定位置元素，并返回该结点的元素
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    Object remove(Node p) throws InvalidNodeException;

    /**
     * 删除第一个元素，并返回
     * @return
     * @throws OutOfBoundsException
     */
    Object removeFirst() throws OutOfBoundsException;

    /**
     * 删除最后一个元素，并返回
     * @return
     * @throws OutOfBoundsException
     */
    Object removeLast() throws OutOfBoundsException;

    /**
     * 替换指定位置的元素，并返回
     * @param p
     * @param o
     * @return
     * @throws InvalidNodeException
     */
    Object replace(Node p, Object o) throws InvalidNodeException;

    /**
     * 元素迭代器
     * @return
     */
    Iterator elements();

}
