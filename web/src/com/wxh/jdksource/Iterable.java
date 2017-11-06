/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 可迭代的接口
 * @author wxh
 * @version $Id: Iterable.java, v 0.1 2017年10月27日 下午2:19:05 wxh Exp $
 */
public interface Iterable<T> {

    /**
     * 迭代器方法
     * @return
     */
    Iterator<T> iterator();
}
