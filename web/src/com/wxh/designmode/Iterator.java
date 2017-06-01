/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 迭代器
 * @author wxh
 * @version $Id: Iterator.java, v 0.1 2017年6月1日 上午11:32:42 wxh Exp $
 */
public interface Iterator {
    /**
     * 是否有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    Object next();
}
