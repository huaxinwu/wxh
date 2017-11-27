/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 迭代器接口
 * @author wxh
 * @version $Id: Iterator.java, v 0.1 2017年11月22日 下午2:54:47 wxh Exp $
 */
public interface Iterator {
    /**
     * 移动到第一个元素
     */
    void first();

    /**
     * 移动到下一个元素
     */
    void next();

    /**
     * 检查迭代器是否还有剩余元素
     * @return
     */
    boolean isDone();

    /**
     * 返回当前元素
     * @return
     */
    Object currentItem();

}
