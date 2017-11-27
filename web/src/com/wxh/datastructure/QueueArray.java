/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 顺序存储实现队列：对象数组实现队列
 * 少使用一个存储单元的方案实现循环队列
 * @author wxh
 * @version $Id: QueueArray.java, v 0.1 2017年11月23日 上午10:26:45 wxh Exp $
 */
public class QueueArray implements Queue {

    /** 队列的默认大小  */
    private static final int CAP = 7;

    /** 数据元素数组  */
    private Object[]         elements;
    /** 数组的大小  */
    private int              capacity;
    /** 队首指针指向队首  */
    private int              front;
    /** 队尾指针 指向队尾的后一个位置  */
    private int              rear;

    /**
     * 扩容
     */
    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        int i = front;
        int j = 0;
        // 将从front开始到rear前一个存储单元的元素复制到新数组
        while (i != rear) {
            // 去除elements[rear]
            a[j++] = elements[i];
            // 向前移动一位
            i = (i + 1) % capacity;
        }
        // 赋值引用地址，将原数组指向新数组的内容
        elements = a;
        capacity = elements.length;
        // 设置新的队首、队尾
        front = 0;
        rear = j;

    }

    /**
     * 初始化参数
     */
    public QueueArray() {
        this(CAP);
    }

    public QueueArray(int cap) {
        capacity = cap + 1;
        elements = new Object[capacity];
        front = rear = 0;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Queue#getSize()
     */
    @Override
    public int getSize() {
        // 队满条件：(rear+1)%capacity=front ===>(rear-front+1)%capacity=size
        // 因为rear从0开始，所以要加上数组的大小
        return (rear - front + capacity) % capacity;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Queue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        // 队首指针与队尾指针重合
        return front == rear;
    }

    /** 
     * 入队，在队尾插入数据元素
     * @param o
     * @see com.wxh.datastructure.Queue#enqueue(java.lang.Object)
     */
    @Override
    public void enqueue(Object o) {
        if (getSize() > (capacity - 1)) {
            // 队列的大小大于数组的大小扩容
            expandSpace();
        }
        // 在队尾插入数据元素
        elements[rear] = o;
        // 队尾指针向前移动一位(逆时针)
        // 比如,capacity=14,rear+1=8,8%14=8
        rear = (rear + 1) % capacity;
    }

    /** 
     * 出队，在队首删除数据元素
     * @return
     * @throws QueueEmptyException
     * @see com.wxh.datastructure.Queue#dequeue()
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("队列为空");
        }
        // 获取队首数据元素\
        Object obj = elements[front];
        // 出队的数据元素让GC回收
        elements[front] = null;
        // 队首指针向前移动一位(逆时针)
        front = (front + 1) % capacity;
        return obj;
    }

    /** 
     * @return
     * @throws QueueEmptyException
     * @see com.wxh.datastructure.Queue#peek()
     */
    @Override
    public Object peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("队列为空");
        }
        return elements[front];
    }

}
