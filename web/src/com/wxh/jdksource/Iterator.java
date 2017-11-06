/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 迭代器接口
 * @author wxh
 * @version $Id: Iterator.java, v 0.1 2017年10月27日 下午2:35:14 wxh Exp $
 */
public interface Iterator<E> {
    /**
     * 判断是否有下一个元素的游标
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    E next();

    /**
     * 移除某个元素
     */
    void remove();

}
