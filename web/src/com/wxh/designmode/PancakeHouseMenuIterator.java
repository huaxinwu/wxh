/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;

/**
 * 
 * @author wxh
 * @version $Id: PancakeHouseMenuIterator.java, v 0.1 2017年6月1日 上午11:44:50 wxh Exp $
 */
public class PancakeHouseMenuIterator implements java.util.Iterator {
    ArrayList menuItems;
    int       position = 0;

    /**
     * 
     */
    public PancakeHouseMenuIterator(ArrayList menuItems) {
        super();
        this.menuItems = menuItems;
    }

    /** 
     * @return
     * @see com.wxh.designmode.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        // 集合容量大小一定是比该容量减去1的
        if (position > menuItems.size() - 1 || menuItems.get(position) == null) {
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
        MenuItem menuItem = (MenuItem) menuItems.get(position);
        position = position + 1;
        return menuItem;
    }

    /** 
     * 
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
    }

}
