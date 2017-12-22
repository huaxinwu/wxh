/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 算法计算圆周长：2PiR
 * @author wxh
 * @version $Id: PiCalculatorPrinter.java, v 0.1 2017年12月22日 下午4:01:33 wxh Exp $
 */
public class PiCalculatorPrinter {

    /**
     * 计算并打印Pi
     * 从算法第九次可以看出pi=3.1415 9265 3589 7932 3846,该值最接近Pi
     */
    static void caluateAndPrintPi() {
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
            System.out.println(iterations + " : " + pi);
            ++iterations;
            sliceWidth /= 2;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        caluateAndPrintPi();
    }
}
