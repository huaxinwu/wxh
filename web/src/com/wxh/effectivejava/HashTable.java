/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 散列桶递归拷贝不行，必须深度拷贝
 * hash表中key分布规律：
 * 1.37%的bucket是空的
 * 2.37%的bucket只有1个key
 * 3.26%的bucket有1个以上的key(hash值冲突)
 * @author wxh
 * @version $Id: HashTable.java, v 0.1 2017年9月6日 下午3:14:33 wxh Exp $
 */
public class HashTable implements Cloneable {

    private Entry[] buckets;

    /**
     * 内部类
     */
    private static class Entry {
        Object key;
        Object value;
        Entry  next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * 每个散列桶都做单链表拷贝
         *
         * @return
         */
        Entry deepCopy() {
            // 递归 会创建很多对象，浪费栈空间
            //            return new Entry(key, value, next == null ? null : next.deepCopy());
            // 迭代 
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    /**
     * 引起克隆对象与原始对象之间不确定行为的改变
     * 行之有效方法是封装一个深度拷贝方法
     * @return
     * @throws CloneNotSupportedException
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        HashTable result = (HashTable) super.clone();
        //        result.buckets = (Entry[]) buckets.clone();
        result.buckets = new Entry[buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                result.buckets[i] = (Entry) buckets[i].deepCopy();
            }
        }
        return result;
    }
}
