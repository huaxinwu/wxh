/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 继承破坏了Java封装性,组合使用重要性
 * 封装类做成包装类
 * @author wxh
 * @version $Id: InstrumentedHashSet.java, v 0.1 2017年9月7日 下午1:57:31 wxh Exp $
 */
public class InstrumentedHashSet implements Set {
    private final Set s;
    private int       addCount = 0;

    public InstrumentedHashSet(Set s) {
        this.s = s;
    }

    public boolean add(Object o) {
        addCount++;
        return s.add(o);
    }

    /**
     * 基于add方法实现
     * @param c
     * @return
     * @see java.util.AbstractCollection#addAll(java.util.Collection)
     */
    public boolean addAll(Collection c) {
        addCount += c.size();
        return s.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    // 转发方法--调用原有类中的方法

    /** 
     * @return
     * @see java.util.Set#size()
     */
    @Override
    public int size() {
        return s.size();
    }

    /** 
     * @return
     * @see java.util.Set#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    /** 
     * @param o
     * @return
     * @see java.util.Set#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    /** 
     * @return
     * @see java.util.Set#iterator()
     */
    @Override
    public Iterator iterator() {
        return s.iterator();
    }

    /** 
     * @return
     * @see java.util.Set#toArray()
     */
    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    /** 
     * @param a
     * @return
     * @see java.util.Set#toArray(java.lang.Object[])
     */
    @Override
    public Object[] toArray(Object[] a) {
        return s.toArray(a);
    }

    /** 
     * @param o
     * @return
     * @see java.util.Set#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    /** 
     * @param c
     * @return
     * @see java.util.Set#containsAll(java.util.Collection)
     */
    @Override
    public boolean containsAll(Collection c) {
        return s.containsAll(c);
    }

    /** 
     * @param c
     * @return
     * @see java.util.Set#retainAll(java.util.Collection)
     */
    @Override
    public boolean retainAll(Collection c) {
        return s.retainAll(c);
    }

    /** 
     * @param c
     * @return
     * @see java.util.Set#removeAll(java.util.Collection)
     */
    @Override
    public boolean removeAll(Collection c) {
        return s.removeAll(c);
    }

    /** 
     * 
     * @see java.util.Set#clear()
     */
    @Override
    public void clear() {
        s.clear();
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }

    public static void main(String[] args) {
        // 每个元素被计算两次
        //        InstrumentedHashSet ihs = new InstrumentedHashSet();
        InstrumentedHashSet ihs = new InstrumentedHashSet(new TreeSet());
        ihs.addAll(Arrays.asList(new String[] { "Snap", "Crackle", "Pop" }));

        System.out.println(ihs.getAddCount());
    }
}
