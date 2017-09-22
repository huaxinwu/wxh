/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 等待队列成果
 * 
 * @author wxh
 * @version $Id: WaitQueuePerf.java, v 0.1 2017年9月21日 上午11:05:54 wxh Exp $
 */
public class WaitQueuePerf {

    public static void main(String[] args) {
        PingPongQueue q1 = new PingPongQueue();
        PingPongQueue q2 = new PingPongQueue();
        q1.enqueue(q2);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("线程中断异常");
        }
        int count = q1.count;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("线程中断异常");
        }
        System.out.println(q1.count - count);
        q1.stop();
        q2.stop();
    }
}

/**
 * 乒乓球队列
 */
class PingPongQueue extends WorkQueue {
    /**  并发线程保证获取到时最新的值   */
    volatile int count = 0;

    /** 
     * @param workItem
     * @throws InterruptedException
     * @see com.wxh.effectivejava.WorkQueue#processItem(java.lang.Object)
     */
    @Override
    protected void processItem(final Object workItem) throws InterruptedException {
        // 并发情况不建议这么使用，会引发count值变动
        count++;
        // 接收人
        WorkQueue recipient = (WorkQueue) workItem;
        recipient.enqueue(this);
    }

}