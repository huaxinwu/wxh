/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 排序
 * @author wxh
 * @version $Id: Sort.java, v 0.1 2017年5月27日 下午1:48:49 wxh Exp $
 */
public class Sort {

    /**
     * 对一个数组进行排序
     * @param o
     */
    public static void sort(Object[] o) {
        Object[] obj = o.clone();
        mergeSort(obj, o, 0, o.length, 0);
    }

    /**
     * 将原数组拷贝到目标数组，从低位到高位，偏离 位
     * @param src
     * @param dest
     * @param low
     * @param high
     * @param off
     */
    private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
        for (int i = low; i < high; i++) {
            for (int j = i; j > low
                            && ((Comparable) dest[j - 1]).compareTo((Comparable) dest[j]) > 0; j--) {
                swap(dest, j, j - 1);
            }
        }
        return;
    }

    /**
     * 交换数组的两个元素的位置
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
