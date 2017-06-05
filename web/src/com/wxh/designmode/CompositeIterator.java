/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 复合迭代器
 * @author wxh
 * @version $Id: CompositeIterator.java, v 0.1 2017年6月5日 下午2:39:34 wxh Exp $
 */
public class CompositeIterator implements Iterator {
    /** 由Vector扩展而来 */
    Stack stack = new Stack();

    /**
     * 
     */
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    /** 
     * @return
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = (Iterator) stack.peek();
            // 如果是最后一个元素，出栈并递归
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    /** 
     * @return
     * @see java.util.Iterator#next()
     */
    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof MenuUnit) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    /** 
     * 
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * 测试复合迭代器
     */
    public void testCompositeIterator(MenuComponent component) {
        CompositeIterator iterator = new CompositeIterator(component.createIterator());
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
        }
    }
}
