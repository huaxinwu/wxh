/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * 增加日志和计时等功能的线程池
 * @author wxh
 * @version $Id: TimingThreadPool.java, v 0.1 2017年11月3日 下午2:13:14 wxh Exp $
 */
public class TimingThreadPool extends ThreadPoolExecutor {

    private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    private final Logger            log       = Logger.getLogger("TimingThreadPool");
    private final AtomicLong        numTasks  = new AtomicLong();
    private final AtomicLong        totalTime = new AtomicLong();

    /**
     * 处理之前将数据保存在ThreadLocal中
     * @param t
     * @param r
     */
    protected void beforeExcutor(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.fine(String.format("Thread %s: start %s", t, r));
        startTime.set(System.nanoTime());
    }

    /**
     * 处理之后从ThreadLocal中读取
     * @param r
     * @param t
     */
    protected void afterExecutor(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            log.fine(String.format("Thread %s: end %s,time=%dns", t, r, taskTime));
        } finally {
            super.afterExecute(r, t);
        }
    }

    /** 
     * 结束 输出包含平均任务时间的日志消息
     * @see java.util.concurrent.ThreadPoolExecutor#terminated()
     */
    protected void terminated() {
        try {
            log.info(String.format("Terminated:avg time=%dns", totalTime.get() / numTasks.get()));
        } finally {
            super.terminated();
        }
    }

    /**
     * @param corePoolSize
     * @param maximumPoolSize
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     */
    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                            TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        // TODO Auto-generated constructor stub
    }

}
