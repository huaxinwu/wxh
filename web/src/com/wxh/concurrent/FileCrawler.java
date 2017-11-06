/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 桌面搜索应用程序中的生产者和消费者的任务
 * @author wxh
 * @version $Id: FileCrawler.java, v 0.1 2017年10月30日 上午10:42:40 wxh Exp $
 */
public class FileCrawler implements Runnable {

    private static final Collection<? extends File> BOUND       = null;

    private static final int                        N_CONSUMERS = 0;

    /** 文件阻塞队列  */
    private BlockingQueue<File>                     fileQueue;

    /** 文件过滤器  */
    private FileFilter                              fileFilter;
    /** 文件 */
    private File                                    root;

    /**
     * @param queue
     * @param fileFilter2
     * @param root2
     */
    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    // 如果是目录，递归
                    crawl(entry);
                } else if (!alreadyIndexed(entry)) {
                    // 不是目录，找到文件，存入队列中
                    fileQueue.put(entry);
                }
            }
        }

    }

    /**
     *
     * @param entry
     * @return
     */
    private boolean alreadyIndexed(File entry) {
        return false;
    }

    /** 
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            // 恢复被中断的线程
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 启动搜索
     * @param roots
     */
    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
        FileFilter fileFilter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };
        // 遍历查找文件
        for (File root : roots) {
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }
        // 遍历将索引存储到阻塞队列中
        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }

}
