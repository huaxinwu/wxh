/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.LinkedList;
import java.util.List;

/**
 * 工作队列
 * @author wxh
 * @version $Id: WorkQueue.java, v 0.1 2017年9月20日 下午4:05:51 wxh Exp $
 */
public abstract class WorkQueue {
    /** 队列，对于插入、删除使用linkedList */
    private final List queue   = new LinkedList();
    private boolean    stopped = false;

    /**
     * 不适用监视器notify
     */
    private class WorkThread2 extends Thread {
        @Override
        public void run() {
            final Object QUERY_IS_EMPTY = new Object();
            while (true) {
                Object workItem = QUERY_IS_EMPTY;
                synchronized (queue) {
                    if (stopped) {
                        return;
                    }
                    if (!queue.isEmpty()) {
                        workItem = queue.remove(0);
                    }
                }
                if (workItem != QUERY_IS_EMPTY) {
                    try {
                        processItem(workItem);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }

    /**
     * 工作线程
     */
    private class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Object workItem = null;
                synchronized (queue) {
                    try {
                        // 队列为空并且停止
                        while (queue.isEmpty() && !stopped) {
                            queue.wait();
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                    if (stopped) {
                        return;
                    }
                    workItem = queue.remove(0);
                    //                    try {
                    //                        // 从一个被同步的代码块中调用外部提供方法引起死锁 
                    //                        processItem(workItem);
                    //                    } catch (InterruptedException e) {
                    //                        return;
                    //                    }
                }
                // 开放调用----避免死锁，增加并发性
                try {
                    // 从一个被同步的代码块中调用外部提供方法引起死锁 
                    processItem(workItem);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    protected WorkQueue() {
        // 开启一个线程
        new WorkThread2().start();
    }

    /**
     * 加入队列
     * @param workItem 对象
     */
    public final void enqueue(Object workItem) {
        // 同步代码块
        synchronized (queue) {
            // 向队列添加一个对象
            queue.add(workItem);
            // 唤醒下一个对象
            //            queue.notify();
        }
    }

    /**
     * 停止线程
     */
    public final void stop() {
        synchronized (queue) {
            stopped = true;
            queue.notify();
        }
    }

    /**
     * 处理队列中每一项 ----抽象方法
     * @param workItem
     */
    protected abstract void processItem(Object workItem) throws InterruptedException;

}

/**
 * 显示队列
 */
class DisplayQueue extends WorkQueue {

    /** 
     * @param workItem
     * @throws InterruptedException
     * @see com.wxh.effectivejava.WorkQueue#processItem(java.lang.Object)
     */
    @Override
    protected void processItem(Object workItem) throws InterruptedException {
        System.out.println(workItem);
        // 休眠1000毫秒
        Thread.sleep(1000);
    }

}

/**
 * 死锁队列
 */
class DeadLockQueue extends WorkQueue {

    /** 
     * @param workItem
     * @throws InterruptedException
     * @see com.wxh.effectivejava.WorkQueue#processItem(java.lang.Object)
     */
    @Override
    protected void processItem(final Object workItem) throws InterruptedException {
        Thread child = new Thread() {
            public void run() {
                enqueue(workItem);
            }
        };
        child.start();
        // 主线程等待子线程的终止后，再终止
        // 发生死锁
        child.join();
    }

}
