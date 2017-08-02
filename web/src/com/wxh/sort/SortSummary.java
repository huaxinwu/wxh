/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.sort;

import java.util.Arrays;

/**
 * 排序汇总
 * 八大常用排序算法：
 * 1.直接插入排序--在一个要排序的数组中，假设前(n-1)(n>=2)个数已经排好顺序，现在把第n个数插到前面已经排好顺序的数中，使得这n个数也排好顺序。如此反复，直到全部排好顺序。
 * 2.希尔排序--递减增量排序，是插入排序的一种演变方式，先取一个正整数d1<n,把所有相隔d1的元素放一组，每个组内进行插入排序；然后d2<d1,重复上述分组和排序，直至di=1,即排序完成。
 * 3.简单选择排序--在要排序的一组数中，选出最小的元素与第一个位置元素进行比较交换位置，然后在剩下的元素中最小的元素与第二个位置元素比较交换位置，如此循环直到倒数第二个元素与倒数第一个元素比较为止。
 * 4.堆排序--堆排序是一种树形选择排序，是对直接选择排序的有效改进。堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 * 5.冒泡排序--在要排序的一组数中，对没有排好序的范围内全部元素，自上而下对相邻两个元素依次比较和调整，让较大的元素往下沉，较小元素往上冒。即：每个相邻两个元素比较后，发现他们排序与排序要求相反，交换位置。
 * 6.快速排序
 * 7.归并排序
 * 8.基数排序
 * @author wxh
 * @version $Id: SortSummary.java, v 0.1 2017年7月14日 下午4:11:15 wxh Exp $
 */
public class SortSummary {
    // 排序初始化数据
    private static final int[] NUMBERS = { 15, 2, 4, 5, 3, 1, 7, 9, 6 };

    public static void main(String[] args) {
        // 直接插入排序
        insertSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 希尔排序
        shellSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 希尔排序
        selectSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 堆排序
        heapSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 冒泡排序
        heapSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");
    }

    /**
     * 直接插入排序
     * 基本思路：内层循环：取第一个元素认为是已经排好顺序的元素，剩下元素与之比较大于就位置移动到其后面，否则设置该元素需要排序 的元素
     *          外层循环：控制循环次数
     *  比如：56 68 59 52 
     *  1.56表示排好顺序，它与剩下的元素进行比较，56和68不做处理，56和59,59插入56之后，
     *  2.57、59和剩下的元素比较，57和52,52插入57之前，其他比较后位置不动
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 要排序的元素
            int temp = array[i];
            // 假设已经排好顺序的元素
            int j = i - 1;
            for (; j >= 0 && array[j] > temp; j--) {
                // 大于temp值元素整体后移
                array[j + 1] = array[j];
            }
            // 要排序的元素
            array[j + 1] = temp;
        }
        System.out.println("insertSort: " + Arrays.toString(array));
    }

    /**
     * 希尔排序
     * 基本思路：将数组元素分为n组，取一个正整数d1<n,把所有相隔d1的元素放在一组，
     *          每个组内进行插入排序，然后d2<d1,重复分组和排序操作，
     *          直到di=1,即所有的元素放在一个组中排序为止。
     *  比如：49 38 65 97 76 13 27 48 55 4
     *  1.取d1=5,表示前每5个元素为一组，组与组相同位置元素比较，使用插入方式而交换位置
     *  2.一趟分组比较下来，13 27 48 55 4 49 38 65 97 76
     *  3.取d2=3,表示每3个元素为一组，组与组相同位置元素比较，使用插入方式而交换位置
     *  4.二趟分组比较下来，13 4 48 38 27 49 55 65 97 76
     *  5.取d3=1,表示每1个元素为一组，组与组相同位置元素比较，使用插入方式而交换位置
     *  6.三趟分组比较下来，4 13 27 38 48 49 55 65 76 97  
     * @param array
     */
    public static void shellSort(int[] array) {
        int i;
        int j;
        int temp;
        // 间隔
        int gap = 1;
        int len = array.length;
        // 分组个数
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        // 分组
        for (; gap > 0; gap /= 3) {
            // 排序
            for (i = gap; i < len; i++) {
                temp = array[i];
                for (j = i - gap; j > 0 && array[j] > temp; j--) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
        }
        System.out.println("shellSort:  " + Arrays.toString(array));
    }

    /**
     * 简单选择排序
     * 基本思路：在要排序的一组数中，选出最小元素，与第一个位置元素比较并交换位置，
     *          在剩下的元素选出最小元素与第二个位置元素比较交换位置，
     *          如此循环直到倒数第二个元素与倒数第一个元素比较为止。
     *          在多数情况下，都是把第一个元素最为最小元素。
     * 比如：56 68 59 52
     * 1.最小元素为52，与第一个比较之后，52 68 59 56
     * 2.剩下中最小元素为56，与第一个比较之后 ，52 56 59 68 
     * 3.剩下中最小元素为59，无需交换，完成排序，52 56 59 68 
     * @param array
     */
    public static void selectSort(int[] array) {
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            position = i;
            int temp = array[i];
            for (; j < array.length; j++) {
                if (array[j] < temp) {
                    // 设置元素位置
                    temp = array[j];
                    position = j;
                }
            }
            array[position] = array[i];
            array[i] = temp;
        }
        System.out.println("selectSort: " + Arrays.toString(array));
    }

    /**
     * 堆排序
     * 基本思路：堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     *      堆定义：具有n个元素序列(h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。
     *      在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素即为第一个元素必为最大项，完全二叉树可以直观表示堆结构。堆顶为根，其它为左子树，右子树。
     *      初始时把要排序的数序列看成一颗顺序存储的二叉树，调整它们存储顺序，使之成为一个堆，这时候堆根节点的数最大，然后根节点与堆最后一个节点比较交换。
     *      然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
     *      从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
     *      所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
     * 比如： 84 79 56 38 40 46 (始终取右节点的数进行交换)
     * 1.建立堆(二叉树) 84          
     *            /  \             
     *           79   56
     *           / \   /
     *         38  40  46 
     *  交换位置：  46 
     *          / \
     *         79  56
     *         / \  /
     *        38 48 84 
     *  2.建立堆(二叉树) 79
     *                 / \
     *                46  56
     *                / \  /
     *               38 40 84  
     * @param array
     */
    public static void heapSort(int[] array) {
        /* 
         *  第一步：将数组堆化 
         *  beginIndex = 第一个非叶子节点。 
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。 
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己在二叉树中值为最大。 
         */
        int len = array.length - 1;
        // 右移1位
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            // 堆化，选出堆中最大值
            maxHeapify(i, len, array);
        }

        /* 
         * 第二步：对堆化数据排序 
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。 
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。 
         * 直至未排序的堆长度为 0。 
         */
        for (int i = len; i > 0; i--) {
            swap(0, i, array);
            maxHeapify(0, i - 1, array);
        }
        System.out.println("headSort:   " + Arrays.toString(array));
    }

    /**
     * 交换数组中两个元素的位置
     * @param i
     * @param j
     * @param array
     */
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性
     * @param index 需要堆化处理的数据的索引 
     * @param len   未排序的堆（数组）的长度 
     * @param array
     */
    public static void maxHeapify(int index, int len, int[] array) {
        // 左子节点索引 (左移1位)
        int leftNode = (index << 1) + 1;
        // 右子节点索引 
        int rightNode = leftNode + 1;
        // 子节点值最大索引，默认左子节点
        int childNodeIndex = leftNode;
        // 左子节点索引超出计算范围，直接返回
        if (leftNode > len) {
            return;
        }
        // 先判断左右子节点，哪个较大
        if (rightNode <= len && array[rightNode] > array[leftNode]) {
            // 将右节点设置最大索引
            childNodeIndex = rightNode;
        }
        if (array[childNodeIndex] > array[index]) {
            // 父子节点交换
            swap(childNodeIndex, index, array);
            // 则需要继续判断换下后面的元素节点是否符合堆的特性
            maxHeapify(childNodeIndex, len, array);
        }
    }

    /**
     * 冒泡排序
     * 基本思路:在要排序一组数中，对没有排好序的范围内全部元素，
     *          自上而下对相邻两个元素依次比较和调整，较大的元素往下沉，较小的元素往上冒。
     *          即：每当两个相邻元素比较后，他们的排序与排序要求相反，交换位置。
     * 比如：56 68 59 52 
     * 1.59和52比较，56 68 52 59 
     * 2.68和52比较，56 52 68 59
     * 3.56和52比较，52 56 68 59 
     * 4.68和59比较，52 56 59 68 
     * 5.56和59比较，不用交换
     * 6.52和56比较，不用交换
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int temp = 0;
        // 循环次数
        for (int i = 0; i < array.length - 1; i++) {
            // 相邻两个元素比较，比较一次减少一个元素比较
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换位置
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //swap(j, j+1, array);
                }
            }
        }
        System.out.println("bubbleSort: " + Arrays.toString(array));
    }
}
