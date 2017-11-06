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

}
