/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 整型比较策略
 * @author wxh
 * @version $Id: IntegerStrategy.java, v 0.1 2017年12月11日 下午3:04:30 wxh Exp $
 */
public class IntegerStrategy implements Strategy {

    /**
     * 将int数组转换为Integer数组
     * @param a
     * @return
     */
    public Integer[] intToInteger(int[] a) {
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.valueOf(a[i]);
        }
        return b;
    }

    /** 
     * @param obj1
     * @param obj2
     * @return
     * @see com.wxh.datastructure.Strategy#equals(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean equals(Object obj1, Object obj2) {
        return false;
    }

    /** 
     * @param obj1
     * @param obj2
     * @return
     * @see com.wxh.datastructure.Strategy#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Object obj1, Object obj2) {
        if (obj1 instanceof Integer && obj2 instanceof Integer) {
            Integer in1 = (Integer) obj1;
            Integer in2 = (Integer) obj2;
            return in1.compareTo(in2);
        }
        return obj1.toString().compareTo(obj2.toString());
    }

}
