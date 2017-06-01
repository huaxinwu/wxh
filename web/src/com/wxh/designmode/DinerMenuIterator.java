/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: DinerMenuIterator.java, v 0.1 2017年6月1日 上午11:36:39 wxh Exp $
 */
public class DinerMenuIterator implements java.util.Iterator {
    MenuItem[] items;
    int        position = 0;

    /**
     * 
     */
    public DinerMenuIterator(MenuItem[] items) {
        super();
        this.items = items;
    }

    /** 
     * @return
     * @see com.wxh.designmode.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        if (position > items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    /** 
     * @return
     * @see com.wxh.designmode.Iterator#next()
     */
    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    /** 
     * 
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException(
                "Your can not remove an item until you've done at least one next()");
        }
        // 实现remove方法将后面元素都往前移动一个位置,相当于扩容
        if (items[position - 1] != null) {
            for (int i = position - 1; i < (items.length - 1); i++) {
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
        }
    }

}
