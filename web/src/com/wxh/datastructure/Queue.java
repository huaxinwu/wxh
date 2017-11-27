/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 队列接口
 * 队列：队首和队尾，队首删除数据元素，队尾插入数据元素
 * @author wxh
 * @version $Id: Queue.java, v 0.1 2017年11月23日 上午10:03:28 wxh Exp $
 */
public interface Queue {
    /**
     * 获取队列的数据元素个数
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 将数据元素入队
     * @param o
     */
    void enqueue(Object o);

    /**
     * 队首元素出队
     * @return
     * @throws QueueEmptyException
     */
    Object dequeue() throws QueueEmptyException;

    /**
     * 获取队首元素
     * @return
     * @throws QueueEmptyException
     */
    Object peek() throws QueueEmptyException;

}
