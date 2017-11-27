/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

import java.util.Arrays;

/**
 * 简单字符串
 * @author wxh
 * @version $Id: SimpleString.java, v 0.1 2017年11月2日 下午2:58:22 wxh Exp $
 */
public final class SimpleString {

    /**存储字符串中的各个字符   */
    private final char[] value;

    /** 存储字符串的哈希值  */
    private int          hash;

    /**
     * 无参构造器
     */
    public SimpleString() {
        this.value = new char[0];
    }

    /**
     * 传入一个字符串参数
     * @param original
     */
    public SimpleString(SimpleString original) {
        this.value = original.value;
        this.hash = original.hash;
    }

    /**
     * 数组拷贝：1.for循环，2.System.arraycopy()，3.Arrays.copyOf()，4.Object.clone()
     * @param values
     */
    public SimpleString(char[] values) {
        this.value = Arrays.copyOf(values, values.length);
    }

    public SimpleString(char[] value, int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    /**
     * 字符串长度
     * @return
     */
    public int length() {
        return value.length;
    }

    /**
     * 判断字符串是否为空
     * @return
     */
    public boolean isEmpty() {
        return value.length == 0;
    }

    /**
     * 获取字符串中指定索引的字符
     * @param index
     * @return
     */
    public char charAt(int index) {
        if (index < 0 || index >= value.length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    /**
     * 比较两个对象的内容是否相同
     * @param anObject
     * @return
     */
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof SimpleString) {
            // 如果传入参数是SimpleString实例，并且两个对象长度相等
            // 通过循环来比较两个对象内容
            SimpleString anotherObject = (SimpleString) anObject;
            int n = value.length;
            if (n == anotherObject.value.length) {
                char[] v1 = value;
                char[] v2 = anotherObject.value;
                int i = 0;
                while (n-- != 0) {
                    // 如果两个字符数组的每个对应字符不相同，直接结束
                    if (v1[i] != v2[i]) {
                        return false;
                    }
                    i++;
                }
                return true;
            }

        }
        return false;
    }

    /**
     * 忽略大小写比较两个对象的内容是否相同
     * @param anotherSimpleString
     * @return
     */
    public boolean equalsIgnoreCase(SimpleString anotherSimpleString) {
        return (this == anotherSimpleString) ? true
            : (anotherSimpleString != null) && (anotherSimpleString.value.length == value.length)
              && regionMatches(true, 0, anotherSimpleString, 0, value.length);
    }

    /**
     * 区间匹配字符
     * @param ignoreCase
     * @param toffset 偏移到那个位置
     * @param other
     * @param ooffset 从哪个位置开始偏移
     * @param len
     * @return
     */
    public boolean regionMatches(boolean ignoreCase, int toffset, SimpleString other, int ooffset,
                                 int len) {
        char[] ta = value;
        int to = toffset;
        char[] pa = other.value;
        int po = ooffset;
        // 如果两个索引位置小于零或者大于字符数组长度,直接返回false
        if (toffset < 0 || ooffset < 0 || (toffset > (value.length - len))
            || (ooffset > other.value.length - len)) {
            return false;
        }
        while (len-- > 0) {
            char c1 = ta[to++];
            char c2 = pa[po++];
            // 如果两个字符相同，进行比较
            if (c1 == c2) {
                continue;
            }
            // 如果是忽略大小写,先将字符转换成大写比较，相同继续比较，在转换成小写比较，相同继续比较
            if (ignoreCase) {
                char u1 = Character.toUpperCase(c1);
                char u2 = Character.toUpperCase(c2);
                if (u1 == u2) {
                    continue;
                }
                if (Character.toLowerCase(u1) == Character.toLowerCase(u2)) {
                    continue;
                }
            }
            return false;
        }
        return true;

    }
}
