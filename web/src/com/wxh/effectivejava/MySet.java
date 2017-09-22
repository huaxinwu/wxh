/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Map接口往往使用非静态成员类来实现它们的集合视图
 * @author wxh
 * @version $Id: MySet.java, v 0.1 2017年9月8日 上午11:28:09 wxh Exp $
 */
public class MySet extends AbstractSet {
    /**
     * 非静态成员类
     */
    private class MyIterator implements Iterator {

        /** 
         * @return
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /** 
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Object next() {
            return null;
        }

        /** 
         * 
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {
        }

    }

    /** 
     * @return
     * @see java.util.AbstractCollection#iterator()
     */
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    /** 
     * @return
     * @see java.util.AbstractCollection#size()
     */
    @Override
    public int size() {
        return 0;
    }

}
