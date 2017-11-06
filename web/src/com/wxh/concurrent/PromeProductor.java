/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 通过中断来取消某个操作
 * @author wxh
 * @version $Id: PromeProductor.java, v 0.1 2017年11月2日 上午10:26:57 wxh Exp $
 */
public class PromeProductor extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PromeProductor(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    /** 
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                // 当前线程没有被中断,存入阻塞队列中
                queue.put(p = p.nextProbablePrime());
            }

        } catch (InterruptedException e) {
            // 中断异常，让线程退出
        }
    }

    /**
     * 中断来取消操作
     */
    public void cancle() {
        interrupt();
    }

}
