/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 集合List
 * @author wxh
 * @version $Id: List.java, v 0.1 2017年10月27日 下午3:35:06 wxh Exp $
 */
public interface List<E> extends Collection<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    /**
     * 在指定位置添加一个集合
     * @param index
     * @param c
     * @return
     */
    boolean addAll(int index, Collection<? extends E> c);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 在指定位置设置元素的值
     * @param index
     * @param elements
     * @return
     */
    E set(int index, E elements);

    /**
     * 在指定位置添加元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 移除指定位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 返回指定位置的元素第一次出现的索引
     * @param o
     * @return
     */
    int indexOf(Object o);

    /**
     * 返回指定位置的元素最后一次出现的索引
     * @param o
     * @return
     */
    int lastIndexOf(Object o);

    ListIterator<E> listIterator();

    /**
     * 获取指定位置的迭代器
     * @param index
     * @return
     */
    ListIterator<E> listIterator(int index);

    /**
     * 返回指定集合的一部分视图
     * @param fromIndex
     * @param toIndex
     * @return
     */
    List<E> subList(int fromIndex, int toIndex);
}
