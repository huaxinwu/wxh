/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：three dimensional array
 * 三维度树
 * @author wxh
 * @version $Id: ThreeDimTree.java, v 0.1 2017年12月21日 下午3:24:56 wxh Exp $
 */
public class ThreeDimTree {

    /**
     * 初始化一个数组
     */
    static void initAnArray() {
        // 创建一个int类型的三维度的数组
        int[][][] threeD = new int[5][4][3];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 3; ++k) {
                    threeD[i][j][k] = i + j + k;
                }
            }
        }
    }

}
