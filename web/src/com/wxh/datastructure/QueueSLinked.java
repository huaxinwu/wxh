/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 链式存储实现队列：单链表实现队列
 * 带头结点的单链表，首部作为队首，尾部作为队尾
 * 单链表首部--头结点指向的第一个元素
 * @author wxh
 * @version $Id: QueueSLinked.java, v 0.1 2017年11月23日 下午1:50:28 wxh Exp $
 */
public class QueueSLinked implements Queue {

    /** 队首指针  */
    private SLNode front;
    /** 队尾指针 */
    private SLNode rear;
    /** 队列 数据元素的个数   */
    private int    size;

    /**
     * 初始化参数
     */
    public QueueSLinked() {
        // 创建一个空结点作为头结点
        front = new SLNode();
        // 队列为空时，队首指针和队尾指针都指向空的头结点
        rear = front;
        size = 0;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Queue#getSize()
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Queue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** 
     * 入队，在队尾插入数据元素
     * @param o
     * @see com.wxh.datastructure.Queue#enqueue(java.lang.Object)
     */
    @Override
    public void enqueue(Object o) {
        // 创建一个新结点,作为尾结点(指针域为Null)
        SLNode p = new SLNode(o, null);
        rear.setNext(p);
        // 队尾指针向前移动一位
        rear = p;
        size++;
    }

    /** 
     * 出队，在队首删除数据元素
     * @return
     * @throws QueueEmptyException
     * @see com.wxh.datastructure.Queue#dequeue()
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (size < 1) {
            throw new QueueEmptyException("队列为空");
        }
        // 获取队首--单链表首部
        SLNode p = front.getNext();
        // 设置队首的引用
        front.setNext(p.getNext());
        size--;
        if (size < 1) {
            // 如果队列为空，队尾指针指向头结点
            rear = front;
        }
        return p.getData();
    }

    /** 
     * @return
     * @throws QueueEmptyException
     * @see com.wxh.datastructure.Queue#peek()
     */
    @Override
    public Object peek() throws QueueEmptyException {
        if (size < 1) {
            throw new QueueEmptyException("队列为空");
        }
        return front.getNext().getData();
    }

}
