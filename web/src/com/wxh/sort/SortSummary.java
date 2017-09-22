/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 排序汇总
 * 八大常用排序算法：
 * 1.直接插入排序--在一个要排序的数组中，假设前(n-1)(n>=2)个数已经排好顺序，现在把第n个数插到前面已经排好顺序的数中，使得这n个数也排好顺序。如此反复，直到全部排好顺序。
 * 2.希尔排序--递减增量排序，是插入排序的一种演变方式，先取一个正整数d1<n,把所有相隔d1的元素放一组，每个组内进行插入排序；然后d2<d1,重复上述分组和排序，直至di=1,即排序完成。
 * 3.简单选择排序--在要排序的一组数中，选出最小的元素与第一个位置元素进行比较交换位置，然后在剩下的元素中最小的元素与第二个位置元素比较交换位置，如此循环直到倒数第二个元素与倒数第一个元素比较为止。
 * 4.堆排序--堆排序是一种树形选择排序，是对直接选择排序的有效改进。堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 * 5.冒泡排序--在要排序的一组数中，对没有排好序的范围内全部元素，自上而下对相邻两个元素依次比较和调整，让较大的元素往下沉，较小元素往上冒。即：每个相邻两个元素比较后，发现他们排序与排序要求相反，交换位置。
 * 6.快速排序--选择一个基准元素，通常选择第一个元素或者最后一个元素，通过一趟扫描，将待排序分成两部分，一部分比基准元素小，一部分比基准元素大或者等于，此时基准元素在其排好序后的正确位置，然后再用同样方法递归地排序划分的两个部分。
 * 7.归并排序--将两个或者两个以上的有序合成一个新的有序表，即把待排序序列分成若干个子序列，每个子序列是有序的，然后再把有序子序列合并成整体有序序列。
 * 8.基数排序--将待比较的数统一为同样数位长度，数位较短的数前面补零，然后，从最低位开始，依次进一次排序，这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
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

        // 选择排序
        selectSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 堆排序
        heapSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 冒泡排序
        bubbleSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 快速排序
        quickSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 归并排序
        mergeSort(NUMBERS);
        System.out.println("----------------------华丽分割线---------------------------");

        // 基数排序
        radixSort(NUMBERS);
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

    /**
     * 快速排序
     * 基本思路：选择一个基准元素，通常选择第一个元素或者最后一个元素，通过一趟扫描，将待排序分成两部分，
     *          一部分比基准元素小，一部分比基准元素大或者等于，此时基准元素在其排好序后的正确位置，
     *          然后再用同样方法递归地排序划分的两部分。
     *  把第一个元素作为key，在数组第一个元素和最后一个元素设置下标，然后用这个key从数组下标j向前遍历比较，
     *  直到找到一个比key小的元素，交换位置完成后。又用key从数组下标i向后遍历比较，直到找到一个大于或者等于key的元素，
     *  交换位置。依次反复循环操作，直至排序完成。
     *  比如：57(key) 68 59 72 28 96 33 24 19 
     *       i                             j
     *  1.57为基准元素，从最后一个元素比较后：19 68 59 72 28 96 33 24 57 
     *  2.57为基准元素，从第一个元素比较后：     19 57 59 72 28 96 33 24 68
     *  3.57为基准元素，从最后一个元素比较后：19 24 59 72 28 96 33 57 68
     *  4.57为基准元素，从第一个元素比较后：     19 24 57 72 28 96 33 59 68
     *  5.57为基准元素，从最后一个元素比较后：19 24 33 72 28 96 57 59 68
     *  6.57为基准元素，从第一个元素比较后：     19 24 33 57 28 96 72 59 68
     *  7.57为基准元素，从最后一个元素比较后：19 24 33 28 57 96 72 59 68
     *  8.57为基准元素，从第一个元素比较后：     19 24 33 28 57 96 72 59 68 
     *  此时57已结排好序，以57为中心将前后划分两部分，采用同样方法递归排序
     *   [19 24 33 28] 57 [96 72 59 68]
     * 1. 19 24 33 28  57  68 72 59 96 
     *... 19 24 33 28  57  68 72 59 96
     *... 19 24 28 33  57  59 68 72 96 排序完成 
     * @param array
     */
    public static void quickSort(int[] array) {
        qucikSort(array, 0, array.length - 1);
        System.out.println("quickSort:  " + Arrays.toString(array));
    }

    /**
     * 获取基准元素位置
     * @param array
     * @param low
     * @param high
     * @return int
     */
    private static int getMiddle(int[] array, int low, int high) {
        // 数组第一个元素最为基准元素
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] > temp) {
                high--;
            }
            // 比基准元素小的移动到低位
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                low++;
            }
            // 比基准元素大的移动到高位
            array[high] = array[low];
        }
        // 中间位置记录到尾部
        array[low] = temp;
        // 中间元素位置
        return low;
    }

    /**
     * 将一个数组的元素按照高位和低位比较排序
     * @param array
     * @param low
     * @param high
     */
    private static void qucikSort(int[] array, int low, int high) {
        if (low < high) {
            // 将数组一分为二,获取中间元素
            int middle = getMiddle(array, low, array.length - 1);
            // 对低位递归排序
            qucikSort(array, low, middle - 1);
            // 对高位递归排序
            qucikSort(array, middle + 1, high);
        }
    }

    /**
     * 归并排序
     * 基本思路：将两个或者两个以上的有序表合成一个新的有序表，即把待排序序列分成若干个子序列，
     *          每个子序列都是有序的，然后再把有序子序列合并成整体的有序序列。
     * 比如：57 68 59 52 72 28 96 33
     * 1.[57 68] [52 59] [28 72] [33 96]
     * 2.[52 57 59 68] [28 33 72 96]
     * 3. 28 33 52 57 59 68 72 96
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        System.out.println("mergeSort:  " + Arrays.toString(array));
    }

    /**
     * 将左右数组排序并合并成一个新数组
     * @param array
     * @param left
     * @param right
     */
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // 找出中间索引 
            int center = (left + right) / 2;
            // 对左边数组进行递归 
            mergeSort(array, left, center);
            // 对右边数组进行递归 
            mergeSort(array, center + 1, right);
            // 合并 左右数组
            mergeSort(array, left, center, right);
        }
    }

    /**
     * 将左右中数组合并一个新数组
     * @param array
     * @param left
     * @param center
     * @param right
     */
    private static void mergeSort(int[] array, int left, int center, int right) {
        // 创建临时数组并赋值
        int[] tempArray = new int[array.length];
        int middle = center + 1;
        // 记录中间数组的索引
        int third = left;
        int temp = left;
        // 左边元素小于中间元素，中间元素下一个位置元素小于右边元素
        while (left <= center && middle <= right) {
            // 从两个数组中取出最小的放入中间数组 
            if (array[left] < array[middle]) {
                tempArray[third++] = array[left++];
            } else {
                tempArray[third++] = array[middle++];
            }
        }
        // 剩余部分依次放入中间数组 
        while (middle <= right) {
            tempArray[third++] = array[middle++];
        }
        while (left <= center) {
            tempArray[third++] = array[left++];
        }
        // 将中间数组中的内容复制回原数组 
        while (temp <= right) {
            array[temp] = tempArray[temp++];
        }
    }

    /**
     * 基数排序
     * 基本思路：将待比较的数值，统一为同样数位长度，数位较短的前面补零，从最低位开始排序，
     *          这样从最低位排序一直到最高位完成后，数列就成了一个有序序列。
     * 比如：135 242 192 93 345 11 24 19
     *      135 242 192 093 345 011 024 019
     *         0    1     2     3   4      5    6   7   8   9 
     *收集个位                   11  242 192  93  24  135 345             19
     *      11  242 192 93  24 135 345 19
     *收集十位                 11 19   24    135 242 345                 192 93
     *      11  19  24  135 242 345  192 93
     *收集百位       11 19 24 93 135 192 242 345            
     *  11 19 24 93 135 192 242 345 
     * @param array
     */
    public static void radixSort(int[] array) {
        // 首先确定排序的次数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                // 交换位置
                max = array[i];
            }
        }
        int count = 0;
        // 判断位数(个位、十位、百位...)
        while (max > 0) {
            max /= 10;
            count++;
        }

        // 建立10个队列
        ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }
        // 通过count来分配和收集元素
        for (int i = 0; i < count; i++) {
            // 分配数组元素
            for (int anArray : array) {
                // 获取count+1的位数的元素
                // 11%10/1 19%100/10
                int x = anArray % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(anArray);
                queue.set(x, queue2);
            }
            int count2 = 0;
            // 收集队列元素
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count2] = queue3.get(0);
                    queue3.remove(0);
                    count2++;
                }
            }
        }
        System.out.println("radixSort:  " + Arrays.toString(array));
    }
}
