/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 *
 * @author wxh
 * @version $Id: Test.java, v 0.1 2017年9月5日 上午10:43:29 wxh Exp $
 */
public class Test {
    /**
     * 原语类型---引用类型
     * @param b
     * @return Boolean
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        System.out.println(exchangeOddEven(10));

        System.out.println(Permutation("abcd", "cba"));
    }

    /**
     * 判断一个字符串是否另一个字符串的置换
     * abc----cba
     * @param A
     * @param B
     * @return
     */
    public static boolean Permutation(String A, String B) {
        // write your code here
        // 如果两个字符串都为空，则表示A是B的置换
        if (A == null && B == null) {
            return true;
        }
        // 如果他们其中一个为空，则示A不是B的置换
        if (A == null || B == null) {
            return false;
        }
        // 创建一个int数组，存放A B字符串中元素
        int[] count = new int[128];
        // A的长度不等于B的长度，则示A不是B的置换
        if (A.length() != B.length()) {
            return false;
        }
        // 遍历A，取出A中元素对应索引放入count数组中
        for (int i = 0; i < A.length(); i++) {
            count[(int) A.charAt(i)]++;
        }
        // 遍历B，取出B中元素对应索引放入count数组中
        for (int i = 0; i < B.length(); i++) {
            count[(int) B.charAt(i)]--;
        }
        // 遍历count数组，判断其中元素是否等于0
        for (int i = 0; i < 128; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 设计一个方法，用尽可能少的指令，将一个整数中奇数数位和偶数数位的数字交换 
     * （如，数位 0 和数位 1 交换，数位 2 和数位 3 交换，等等）
     * 思路：我们知道由于奇偶位是相邻的，奇数位平移一位就是偶数位，
     *      反过来偶数位平移一位就是奇数位，那么这题我们可以分别将原来的奇数位和偶数位分别提取出来，
     *      各自平移一位，再将其混合成结果即可(位或)。
     * @param x
     * @return
     */
    public static int exchangeOddEven(int x) {
        // 1. 第一种思路
        //        int oddVal = (x & 0xAAAAAAAA);
        //        int evenVal = (x & 0x55555555);
        //        return (oddVal >> 1) + (evenVal << 1);

        // 2.第二种思路
        //10进制转为2进制
        //        String s = Integer.toBinaryString(x);
        //        //二进制的位数为奇数时，需要在高位加0
        //        if (s.length() % 2 != 0) {
        //            s = "0" + s;
        //        }
        //        char[] arr = s.toCharArray();
        //        //完成奇偶位置的元素的交换
        //        for (int i = 0; i < arr.length - 1; i++) {
        //            if (i % 2 == 0) {
        //                char temp = arr[i];
        //                arr[i] = arr[i + 1];
        //                arr[i + 1] = temp;
        //            }
        //        }
        //        //把2进制转为10进制
        //        return Integer.parseInt(String.valueOf(arr), 2);

        // 3.第三种思路 
        //奇数位左移一位
        //        int odd = ((x & 0x55555555) << 1);
        //        // 偶数位右移一位，并且高位0补充
        //        int even = ((x & 0xAAAAAAAA) >> 1) & 0x7fffffff;
        //        // 奇数位和偶数位位或运算，交换位置
        //        return even | odd;

        // 4.第四种思路，忽略符号位
        // 对于32位的int类型，01010101010101010101010101010101,换成十六进制数是0x55555555
        // 对于32位的int类型，10101010101010101010101010101010，换成十六进制数为0xaaaaaaaa
        return ((x & 0xaaaaaaaa) >>> 1 | (x & 0x55555555) << 1);
    }

}
