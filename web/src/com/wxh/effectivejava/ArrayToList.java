/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.AbstractList;
import java.util.List;

/**
 * 数组转换成集合List
 * @author wxh
 * @version $Id: ArrayToList.java, v 0.1 2017年9月8日 上午10:06:37 wxh Exp $
 */
public class ArrayToList {

    /**
     * 
     * 静态工厂方法
     * @param array
     * @return List
     */
    static List intArrayAsList(final int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        // 匿名内部类
        return new AbstractList() {
            @Override
            public Object get(int index) {
                return new Integer(array[index]);
            }

            @Override
            public int size() {
                return array.length;
            }

            @Override
            public Object set(int index, Object o) {
                int oldValue = array[index];
                array[index] = ((Integer) o).intValue();
                return new Integer(oldValue);
            }

        };
    }
}
