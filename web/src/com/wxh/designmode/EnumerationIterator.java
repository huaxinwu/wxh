/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 枚举迭代适配器
 * @author wxh
 * @version $Id: EnumerationIterator.java, v 0.1 2017年5月22日 下午2:20:08 wxh Exp $
 */
public class EnumerationIterator implements Iterator {

    Enumeration eum;

    /**
     * 
     */
    public EnumerationIterator(Enumeration eum) {
        this.eum = eum;
    }

    /** 
     * @return
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        return eum.hasMoreElements();
    }

    /** 
     * @return
     * @see java.util.Iterator#next()
     */
    @Override
    public Object next() {
        return eum.nextElement();
    }

    /** 
     * 不支持打开异常
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
