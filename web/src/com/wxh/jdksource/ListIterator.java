/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * List迭代器
 * @author wxh
 * @version $Id: ListIterator.java, v 0.1 2017年10月27日 下午3:57:48 wxh Exp $
 */
public interface ListIterator<E> extends Iterable<E> {

    /**
     * 判断是否有下一个元素的游标
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    E next();

    /**
     * 判断是否有上一个元素游标
     * @return
     */
    boolean hasPrevious();

    /**
     * 获取上一个元素
     * @return
     */
    E previous();

    /**
     * 下一个元素的索引
     * @return
     */
    int nextIndex();

    /**
     * 上一个元素的索引
     * @return
     */
    int previousIndex();

    /**
     * 移除元素
     */
    void remove();

    /**
     * 设置元素
     * @param e
     */
    void set(E e);

    /**
     * 添加元素
     * @param e
     */
    void add(E e);
}
