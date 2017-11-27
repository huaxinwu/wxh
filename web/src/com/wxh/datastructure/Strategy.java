/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 比较策略
 * @author wxh
 * @version $Id: Strategy.java, v 0.1 2017年11月20日 下午3:12:32 wxh Exp $
 */
public interface Strategy {

    /**
     * 判断两个数据元素是否相等
     * @param obj1
     * @param obj2
     * @return
     */
    boolean equals(Object obj1, Object obj2);

    /**
     * 比较两个数据元素的大小
     * 如果obj1 < obj2,返回 -1
     * 如果obj1 = obj2,返回 0
     * 如果obj1 > obj2,返回 1
     * @param obj1
     * @param obj2
     * @return
     */
    int compare(Object obj1, Object obj2);
}
