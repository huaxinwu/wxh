/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 递归算法：在定义自身同时又出现了对自身的引用，比如直接或者间接地调用自己
 * 递归分类：基于归纳的递归和分治法
 * 递归条件：1.临界条件，什么时候终止递归；2.调用自身
 * @author wxh
 * @version $Id: Recursion.java, v 0.1 2017年11月24日 上午11:37:35 wxh Exp $
 */
public class Recursion {

    /**
     * 盘子从塔座上移动到另一个塔座上
     * @param n
     * @param x
     * @param y
     */
    private void move(int n, char x, char y) {
        System.out.println("Move " + n + " from " + x + " to " + y);
    }

    /**
     * 打印布尔变量值
     * @param b
     */
    private void outBoolean(int[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println();
    }

    /**
     * 成对
     */
    private class IntPair {
        int x;
        int y;

        @Override
        public String toString() {
            return "x值：" + this.x + ",y值：" + this.y;
        }
    }

    /**
     * 算法：factorial--阶乘
     * 输入：正整数n
     * 输出：n的阶乘
     * 解决方法：数学公式           1 (n=0)
     *              f(n)= n(n-1) (n>0)
     * @param n
     * @return
     */
    public int factorial(int n) {
        // 1.递归终止条件
        if (n == 0) {
            return 1;
        }
        // 2.调用自身--递归方法
        return n * factorial(n - 1);
    }

    /**
     * 算法：power--次幂
     * 输入：整数x,非负整数n
     * 输出：x^n，x的n次幂
     * 解决方法：       1 n=0
     *      f(n)= (x^(n/2))^2 n>0,n为偶数
     *            (x^(n/2))^2*x n>0,n为奇数
     * @param n
     * @return
     */
    public int power(int x, int n) {
        int y;
        // 1.递归终止条件 
        if (n == 0) {
            y = 1;
        } else {
            // 2.调用自身--递归方法
            y = power(x, n / 2);
            // n为偶数
            y = y * y;
            // n为奇数
            if (n % 2 == 1) {
                y = y * x;
            }
        }
        return y;
    }

    /**
     * 算法：hanio--汉若塔
     * 输入：正整数n,塔座x、y、z
     * 输出：n阶Hanoi塔的移动步骤
     * 解决方法：3阶汉诺塔移动步骤
     *  第1步： 将 1号圆盘从 A 移动到 C  
     *  第2步： 将 2号圆盘从 A 移动到 B  
     *  第3步： 将 1号圆盘从 C 移动到 B  
     *  第4步： 将 3号圆盘从 A 移动到 C  
     *  第5步： 将 1号圆盘从 B 移动到 A  
     *  第6步： 将 2号圆盘从 B 移动到 C  
     *  第7步： 将 1号圆盘从 A 移动到 C  
     * @param n
     * @param x
     * @param y
     * @param z
     */
    public void hanio(int n, char x, char y, char z) {
        // 1.递归终止条件 
        if (n == 1) {
            // 将盘子从塔座x移动到塔座z上
            move(n, x, z);
        } else {
            // 2.调用自身--递归方法
            hanio(n - 1, x, z, y);
            // 将盘子从塔座x移动到塔座z上
            move(n, x, z);
            // 塔座y上先移动塔座x，再移动到塔座z上
            hanio(n - 1, y, x, z);
        }
    }

    /**
     * 算法：coding--编码(1,0组合)
     * 输入：正整数n,int数组
     * 输出：n位布尔变量值的所有组合(2的n次幂)
     * 解决方法：这样n个布尔变量的所有组合是在n-1个布尔变量的每种组合的基础上加上1或0而分别得到的结果
     * @param b
     * @param n
     */
    public void coding(int[] b, int n) {
        // 1.递归终止条件 
        if (n == 0) {
            // 赋值
            b[n] = 0;
            // 输出布尔变量值
            outBoolean(b);
            b[n] = 1;
            outBoolean(b);
        } else {
            b[n] = 0;
            // 2.调用自身--递归方法
            coding(b, n - 1);
            b[n] = 1;
            coding(b, n - 1);
        }
    }

    /**
     * 算法：simpleMinMax--简单的最小值和最大值
     * 输入：整数数组a[0,n-1]
     * 输出：数组a中的最小值和最大值
     *
     * @param a
     * @return
     */
    public IntPair simpleMinMax(int[] a) {
        IntPair pair = new IntPair();
        // 设置数组第一个元素作为最小值
        pair.x = a[0];
        // 设置数组第一个元素最为最大值
        pair.y = a[0];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            // 如果实体pair的属性x的值小于数组中某个元素值，则该值是最大值，赋值给pair.x
            if (pair.x < a[i]) {
                pair.x = a[i];
            }
            // 如果实体pair的属性y的值大于数组中某个元素值，则该值是最小值，赋值给pair.y
            if (pair.y > a[i]) {
                pair.y = a[i];
            }
        }
        return pair;
    }

    /**
     * 算法：minMax--最小值和最大值
     * 输入：整数数组a[0,n-1],数组起始位置from,数组终止位置to
     * 输出：数组a中最小值和最大值
     * @param a
     * @param low
     * @param high
     * @return
     */
    public IntPair minMax(int[] a, int from, int to) {
        IntPair pair = new IntPair();
        if (from > to - 2) {
            if (a[from] > a[to]) {
                pair.x = a[to];
                pair.y = a[from];
            } else {
                pair.x = a[from];
                pair.y = a[to];
            }
        } else {
            int mid = (from + to) / 2;
            // 将数组分成两个数组递归
            IntPair p1 = minMax(a, from, mid);
            IntPair p2 = minMax(a, mid + 1, to);
            // 找出最小值和最大值
            pair.x = p1.x > p2.x ? p1.x : p2.x;
            pair.y = p1.y < p2.y ? p1.y : p2.y;
        }
        return pair;
    }

    /**
     * 测试递归应用
     * @param args
     */
    public static void main(String[] args) {

        Recursion recursion = new Recursion();
        // 阶乘
        System.out.println(recursion.factorial(6));
        System.out.println("---------------------------");

        // 次幂
        System.out.println(recursion.power(2, 3));
        System.out.println("---------------------------");

        // n阶汉诺塔
        recursion.hanio(3, 'A', 'B', 'C');
        System.out.println("---------------------------");

        // 编码机(1,0)
        int[] b = new int[3];
        recursion.coding(b, 2);
        System.out.println("---------------------------");

        // 最小值也最大值
        int[] array = { 3, 1, 5, 6 };
        System.out.println(recursion.simpleMinMax(array));
        System.out.println(recursion.minMax(array, 2, 3));
        System.out.println(recursion.minMax(array, 0, 3));
    }

}
