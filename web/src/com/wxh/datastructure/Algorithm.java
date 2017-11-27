/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

import java.util.Arrays;

/**
 * 算法5个特性：输入、输出、可行性、有穷性、确定性
 * @author wxh
 * @version $Id: Algorithm.java, v 0.1 2017年11月17日 下午5:03:06 wxh Exp $
 */
public class Algorithm {

    private Algorithm() {
    }

    /**
     * 简单选择排序：在一个数组a[0,n-1]中，找出最小的元素放入a[0]，在剩下的元素中找出最小元素放入a[1]，如此循环完成排序
     */
    public static void selectSort(int[] ary) {
        int n = ary.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ary[i] > ary[j]) {
                    int temp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 12, 23, 9, 24, 15, 3, 18 };
        selectSort(array);
        System.out.println("selectSort: " + Arrays.toString(array));
    }

}
