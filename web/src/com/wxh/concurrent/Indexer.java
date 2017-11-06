/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 索引线程
 * @author wxh
 * @version $Id: Indexer.java, v 0.1 2017年10月30日 上午10:56:55 wxh Exp $
 */
public class Indexer implements Runnable {
    private BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    /** 
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            while (true) {
                // 获取队列中的资源
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 
     * @param take
     */
    private void indexFile(File take) {
    }

}
