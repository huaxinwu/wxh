/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 数学中Pi的计算器
 * @author wxh
 * @version $Id: PiCalculator.java, v 0.1 2017年12月22日 下午3:51:37 wxh Exp $
 */
public class PiCalculator {

    /**
     * JMV执行计算Pi产生的字节码序列
     * 计算Pi值
     */
    static void calulatePi() {
        double pi = 4.0;
        // 切片宽度
        double sliceWidth = 0.5;
        double y;
        // 迭代次数
        int iterations = 1;

        for (;;) {
            double x = 0.0;
            while (x < 1.0) {
                y = Math.sqrt(1 - (x * x));
                pi -= 4 * (sliceWidth * y);
                x += sliceWidth;

                y = Math.sqrt(1 - (x * x));
                pi += 4 * (sliceWidth * y);
                x += sliceWidth;
            }
            ++iterations;
            sliceWidth /= 2;
        }
    }
}
