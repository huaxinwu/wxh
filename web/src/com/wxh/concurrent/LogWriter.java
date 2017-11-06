/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 不支持关闭的生产者---消费者的日志服务
 * 读取、写入日志的两个线程都放入阻塞队列中
 * @author wxh
 * @version $Id: LogWriter.java, v 0.1 2017年11月2日 下午1:43:39 wxh Exp $
 */
public class LogWriter {
    private final BlockingQueue<String> queue;
    private final LoggerThread          logger;

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        /** 
         * 
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            try {
                while (true) {
                    // 读取日志是一个线程
                    writer.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }
    }

    public LogWriter(PrintWriter writer) {
        this.queue = new LinkedBlockingQueue<String>();
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    /**
     * 写入日志是一个线程
     * @param msg
     * @throws InterruptedException
     */
    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

}
