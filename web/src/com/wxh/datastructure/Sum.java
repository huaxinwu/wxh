/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 1+2+...+100的和
 * 这样写效率不是最高效？
 * @author wxh
 * @version $Id: Sum.java, v 0.1 2017年10月31日 下午4:49:13 wxh Exp $
 */
public class Sum {

    /**
     * 最简单求和
     * @param n
     * @return
     */
    public static int sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 高斯求和(等差数列)Sn=a1*n+[n*(n-1)*d]/2或Sn=[n*(a1+an)]/2
     * @param n
     * @return
     */
    public static int sumWithGaoSi(int n) {
        return n * (1 + n) / 2;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("最简单1+2+...+100的和:" + sum);
        System.out.println("----------------------------------");
        System.out.println("最简单1+2+...+100的和:" + sum(100));
        System.out.println("----------------------------------");
        System.out.println("高斯1+2+...+100的和:" + sumWithGaoSi(100));

    }
}
