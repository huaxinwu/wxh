/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Iterator;

/**
 * 空迭代器
 * @author wxh
 * @version $Id: NullIterator.java, v 0.1 2017年6月5日 下午2:39:11 wxh Exp $
 */
public class NullIterator implements Iterator {

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
        throw new UnsupportedOperationException();
    }

}
