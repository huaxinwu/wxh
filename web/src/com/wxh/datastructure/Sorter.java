/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 排序定义
 * 排序：将一个数据元素的任意序列，重新排列成一个按关键字(元素的值)有序的序列。
 * 根据数据元素数量分两类：内部排序和外部排序
 * 内部排序：插入排序、交换排序、选择排序、归并排序等
 * 外部排序：多路平衡归并、置换-选择排序、最佳归并树
 * @author wxh
 * @version $Id: Sorter.java, v 0.1 2017年12月11日 上午11:11:24 wxh Exp $
 */
public class Sorter {

    /** 比较策略 实现类 */
    private static IntegerStrategy strategy = new IntegerStrategy();

    /**
     * 一趟步长为delta[k]的直接插入排序
     * @param r
     * @param low
     * @param high
     * @param deltaK
     */
    private void shellSort(Object[] r, int low, int high, int deltaK) {
        // 遍历
        for (int i = low + deltaK; i <= high; i++) {
            // 比较两个相邻元素,r[i]小于r[i - deltaK]时，需将r[i]插入有序表
            if (strategy.compare(r[i], r[i - deltaK]) < 0) {
                // 待插入元素
                Object temp = r[i];
                // 设置步长
                int j = i - deltaK;
                // 遍历排序，步长缩短
                for (; j >= low && strategy.compare(temp, r[j]) < 0; j = j - deltaK) {
                    // 元素位置后移
                    r[j + deltaK] = r[j];
                }
                // 将待插入元素插入到正确的位置
                r[j + deltaK] = temp;
            }
        }

    }

    /**
     * 算法：partition--划分过程(快速排序将数组一分为二的过程)
     * 输入：数据元素数组r,划分序列区间[low,high]
     * 输出：将序列划分为两个子序列并返回枢轴元素的位置
     * @param r
     * @param low
     * @param high
     * @return
     */
    private int partition(Object[] r, int low, int high) {
        // 使用r[low]作为枢轴元素
        Object pivot = r[low];
        // 从两端交替向内扫描,向数组中间位置靠拢
        while (low < high) {
            // 如果枢轴元素小于r[high],high递减
            while (low < high && strategy.compare(r[high], pivot) >= 0) {
                high--;
            }
            // 如果枢轴元素大于r[high],将比枢轴元素小的元素移向低端
            r[low] = r[high];
            // 如果枢轴元素大于r[low],low递增
            while (low < high && strategy.compare(r[low], pivot) <= 0) {
                low++;
            }
            // 如果枢轴元素小于r[low],将比枢轴元素大的元素移向高端
            r[high] = r[low];
        }
        // 设置枢轴元素
        r[low] = pivot;
        // 返回枢轴元素的位置
        return low;
    }

    /**
     * 算法：heapAdjust--堆调整(堆排序中的调整)
     * 输入：数据元素数组r,数组r待调整区间[low,high]
     * 输出：调整r[low,high]使之成为大顶堆(就是前面元素大于后面元素)
     * @param r
     * @param low
     * @param high
     */
    private void heapAdjust(Object[] r, int low, int high) {
        // 待调整的元素,除r[low]之外,其余元素均满足堆的定义
        Object temp = r[low];
        // 沿关键字较大的元素向下进行筛选
        for (int j = 2 * low; j <= high; j++) {
            // 比较相邻两个元素，差值小于零，j自增
            if (j < high && strategy.compare(r[j], r[j + 1]) < 0) {
                j++;
            }
            //若temp比其孩子都大，结束for循环
            if (strategy.compare(temp, r[j]) >= 0) {
                break;
            }
            // 元素向下筛选
            r[low] = r[j];
            // 赋值
            low = j;
        }
        r[low] = temp;
    }

    /**
     * 算法：merge--合并数组
     * 输入：数据元素数组a，a待合并的两个有序区间[p,q]和[q+1,r]
     * 输出：将两个有序区间合并为一个有序区间
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private void merge(Object[] a, int p, int q, int r) {
        // 创建一个对象数组，长度为r-p+1
        Object[] b = new Object[r - p + 1];
        // 两个区间:[p,q]和[q+1,r]
        int s = p;
        // 两个区间：[s,t-1]和[t,r]
        int t = q + 1;
        // 标记位
        int k = 0;
        // 遍历,区间[q,r]
        while (s <= q && t <= r) {
            if (strategy.compare(a[s], a[t]) < 0) {
                // 如果a[s]小于a[t],则将a[s++]赋值给b[k++],下标自增
                b[k++] = a[s++];
            } else {
                // 如果a[s]大于a[t],则将a[t++]赋值给b[k++],下标自增
                b[k++] = a[t++];
            }
        }
        // 遍历，s <= q情况
        while (s <= q) {
            b[k++] = a[s++];
        }
        // 遍历,t <= r情况
        while (t <= r) {
            b[k++] = a[t++];
        }
        // 遍历对象数组b,将数组b元素赋值给数组a，数组a下标自增i
        for (int i = 0; i < b.length; i++) {
            a[p + i] = b[i];
        }
    }

    /**
     * 算法：insertSort--直接插入排序
     * 输入：数据元素数组r,数组r待排序区间[low,high]
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     */
    public void insertSort(Object[] r, int low, int high) {
        // 遍历，以数组第一个元素，认为是排好序，与剩下的元素比较大小
        for (int i = low + 1; i <= high; i++) {
            // 比较两个相邻元素,r[i]小于r[i - 1]时，需将r[i]插入有序表
            if (strategy.compare(r[i], r[i - 1]) < 0) {
                // 将待排序的元素储存为临时变量
                Object temp = r[i];
                // 将待排序前一个元素往后移一位,就是r[i]的值变动
                r[i] = r[i - 1];
                // 获取已经排好序的元素下标
                int j = i - 2;
                // 遍历排序，j大于low并且temp小于r[j]
                for (; j >= low && strategy.compare(temp, r[j]) < 0; j--) {
                    // 将已排序的的元素往后移，直到找到待排序元素的位置
                    r[j + 1] = r[j];
                }
                // 在已经排好序的元素后面插入待排序元素,就是r[i-1]的值变动
                // j+1=i-2+1=i-1
                r[j + 1] = temp;
            }
        }
    }

    /**
     * 算法：binaryInsertSort--折半插入排序
     * 输入：数据元素数组r,数组r待排序区间[low,high]
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     */
    public void binaryInsertSort(Object[] r, int low, int high) {
        // 遍历
        for (int i = low + 1; i <= high; i++) {
            // 待插入的元素
            Object temp = r[i];
            // 设置初始区间的高位
            int hi = i - 1;
            // 设置初始区间的低位
            int lo = low;
            // 遍历，折半插入条件
            while (lo < hi) {
                // 获取数组的中间位置
                int middle = (lo + hi) / 2;
                // 待插入元素与数组中间位置的元素比较
                if (strategy.compare(temp, r[middle]) < 0) {
                    // 高位移动到中间位置的前一位
                    hi = middle - 1;
                } else {
                    // 低位移动到中间位置后一位
                    lo = middle + 1;
                }
            }
            // 遍历排序，移动元素，就是元素值大的移动到后面
            for (int j = i - 1; j > hi; j--) {
                r[j + 1] = r[j];
            }
            // 将待插入元素插入到正确的位置
            // hi+1=i-1+1=i
            r[hi + 1] = temp;
        }
    }

    /**
     * 算法：shellSort--希尔排序
     * 输入：数据元素数组r,数组r待排序区间[low,high],步长序列
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     * @param delta
     */
    public void shellSort(Object[] r, int low, int high, int[] delta) {
        for (int k = 0; k < delta.length; k++) {
            // 一趟步长为delta[k]的直接插入排序
            shellSort(r, low, high, delta[k]);
        }
    }

    /**
     * 算法：bubbleSort--冒泡排序(交换类排序中的一种排序)
     * 输入：数据元素数组r,数组r待排序区间[low,high]
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     */
    public void bubbleSort(Object[] r, int low, int high) {
        // 获取循环遍历的次数
        int n = high - low + 1;
        // 遍历，控制比较的次数,这里也可以这样int i=0;i<n-1;i++
        for (int i = 1; i < n; i++) {
            // 遍历，每比较依次，减少和一个元素的比较
            for (int j = low; j <= high - i; j++) {
                // 比较两个相邻元素，前者大于后者，交换位置
                if (strategy.compare(r[j], r[j + 1]) > 0) {
                    // 待交换位置的元素
                    Object temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 算法：quickSort--快速排序
     * 输入：数据元素数组r,数组r待排序区间[low,high]
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     */
    public void quickSort(Object[] r, int low, int high) {
        // 如果low小于high,将数组一分为二，设置枢轴元素位置
        if (low < high) {
            int pa = partition(r, low, high);
            // 递归,从high向前逐一查找比枢轴元素小的元素
            quickSort(r, low, pa - 1);
            // 递归,从low向后逐一查找比枢轴元素大的元素
            quickSort(r, pa + 1, high);
        }
    }

    /**
     * 算法：selectSort--简单选择排序
     * 输入：数据元素数组r,数组r待排序区间[low,high]
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     */
    public void selectSort(Object[] r, int low, int high) {
        // 从n-1趟选取元素进行循环
        for (int k = low; k < high - 1; k++) {
            // 默认第一个是数组中最小元素
            int min = k;
            // 选择出元素值最小的元素
            for (int i = min + 1; i <= high; i++) {
                // 如果数组中元素值小于r[min]，则数组中元素值是最小的
                if (strategy.compare(r[i], r[min]) < 0) {
                    min = i;
                }
            }
            // 如果k与min不相等
            if (k != min) {
                // 关键字最小的元素与元素r[k]交换
                Object temp = r[k];
                r[k] = r[min];
                r[min] = temp;
            }
        }
    }

    /**
     * 算法：heapSort--堆排序
     * 输入：数据元素数组r
     * 输出：对r[1,length-1]排序
     * @param r
     */
    public void heapSort(Object[] r) {
        // 获取循环次数
        int n = r.length - 1;
        // 遍历
        for (int i = n / 2; i >= 1; i--) {
            // 初始化建堆
            heapAdjust(r, i, n);
        }
        // 不断输出堆顶元素并调整r[1,i-1]为新堆
        for (int i = n; i > 1; i--) {
            // 交换堆顶元素与堆底元素
            Object temp = r[1];
            r[1] = r[i];
            r[i] = temp;
            // 调整堆
            heapAdjust(r, 1, i - 1);
        }
    }

    /**
     * 算法：mergetSort--归并排序
     * 输入：数据元素数组r,数组r待排序区间[low,high]
     * 输出：数组r以关键字排序的有序序列
     * @param r
     * @param low
     * @param high
     */
    public void mergetSort(Object[] r, int low, int high) {
        if (low < high) {
            // 在区间[low,(high + low) / 2]递归
            mergetSort(r, low, (high + low) / 2);
            // 在区间[(high + low) / 2 + 1,high]递归
            mergetSort(r, (high + low) / 2 + 1, high);
            // 合并两个区间
            merge(r, low, (high + low) / 2, high);
        }
    }

    /**
     * 打印对象数组各个元素
     * @param a
     */
    public void printArray(String sortType, Object[] a) {
        System.out.print(sortType + "[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 测试排序
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个对象
        Sorter sorter = new Sorter();
        // 创建一个待排序的数组
        Object[] a = { 26, 53, 48, 11, 13, 48, 32, 15 };
        // 调用直接插入排序方法
        sorter.insertSort(a, 0, a.length - 1);
        // 打印数组
        sorter.printArray("直接插入排序：", a);
        System.out.println("--------------------------------------------------");

        // 调用折半插入排序方法
        sorter.binaryInsertSort(a, 0, a.length - 1);
        sorter.printArray("折半插入排序：", a);
        System.out.println("--------------------------------------------------");

        Object[] b = { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
        // 步长序列
        int[] deltaK = { 5, 3, 1 };
        // 调用希尔排序方法
        sorter.shellSort(b, 0, b.length - 1, deltaK);
        sorter.printArray("希尔排序：", b);
        System.out.println("--------------------------------------------------");

        // 调用冒泡排序方法
        sorter.bubbleSort(a, 0, a.length - 1);
        sorter.printArray("冒泡排序：", a);
        System.out.println("--------------------------------------------------");

        // 调用快速排序方法
        sorter.quickSort(a, 0, a.length - 1);
        sorter.printArray("快速排序：", a);
        System.out.println("--------------------------------------------------");

        // 调用简选择s排序
        sorter.selectSort(a, 0, a.length - 1);
        sorter.printArray("简单选择排序：", a);
        System.out.println("--------------------------------------------------");

        // 调用堆排序方法
        sorter.heapSort(a);
        sorter.printArray("堆排序：", a);
        System.out.println("--------------------------------------------------");

        // 调用归并排序方法
        sorter.mergetSort(a, 0, a.length - 1);
        sorter.printArray("归并排序：", a);
        System.out.println("--------------------------------------------------");
    }
}
