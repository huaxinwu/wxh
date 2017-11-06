/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 集合框架顶层接口
 * 接口中只有常量和公共抽象方法
 * Java泛型中的标记符含义： 
 * E - Element (在集合中使用，因为集合中存放的是元素)
 * T - Type（Java 类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ？ -  表示不确定的java类型
 * S、U、V  - 2nd、3rd、4th types
 * @author wxh
 * @version $Id: Collection.java, v 0.1 2017年10月27日 下午2:21:00 wxh Exp $
 */
public interface Collection<E> extends Iterable<E> {

    /**
     *集合的容量
     * @return
     */
    int size();

    /**
     * 非空判断
     * @return
     */
    boolean isEmpty();

    /**
     * 包含某个元素
     * @param o
     * @return
     */
    boolean contains(Object o);

    /** 
     * 获取一个迭代器
     * 
     */
    Iterator<E> iterator();

    /**
     * 获取一个对象数组
     * @return
     */
    Object[] toArray();

    /**
     * 获取一个泛型数组
     * @param a
     * @return
     */
    <T> T[] toArray(T[] a);

    /**
     * 添加一个元素
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 移除一个元素
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 包含一个集合
     * @param c
     * @return
     */
    boolean containsAll(Collection<?> c);

    /**
     * 添加一个集合
     * 可以添加是E类型或者它的子类构成集合
     * @param c
     * @return
     */
    boolean addAll(Collection<? extends E> c);

    /**
     * 移除一个集合
     * @param c
     * @return
     */
    boolean removeAll(Collection<?> c);

    /**
     * 保留一个集合
     * @param c
     * @return
     */
    boolean retainAll(Collection<?> c);

    /**
     * 清除集合中的所有元素
     */
    void clear();

    /**
     * 与一个对象进行比较，比较对象之间的内容
     * @param o
     * @return
     */
    boolean equals(Object o);

    /**
     * 获取集合的hashcode值
     * @return
     */
    int hashCode();
}
