/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：hop around
 * 跳来跳去
 * @author wxh
 * @version $Id: Clown.java, v 0.1 2017年12月21日 下午4:41:06 wxh Exp $
 */
public class Clown {

    /**
     * 跳来跳去
     * 这个方法永远无法返回，第二个finally子句continue取代return语句
     * @return
     */
    static int hopAround() {
        int i = 0;
        while (true) {
            try {
                try {
                    i = 1;
                } finally {
                    i = 2;
                }
                i = 3;
                // 2.结束程序返回
                return i;
            } finally {
                if (i == 3) {
                    // 1.继续执行
                    continue;
                }
            }
        }
    }

    /**
     * 测试finally和return关系
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("输出结果：" + hopAround());
    }
}
