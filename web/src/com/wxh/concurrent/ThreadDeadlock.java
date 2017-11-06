/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 在单线程Executor框架中任务发生死锁(不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: ThreadDeadlock.java, v 0.1 2017年11月3日 上午10:49:20 wxh Exp $
 */
public class ThreadDeadlock {
    // 执行服务器
    ExecutorService exec = Executors.newSingleThreadExecutor();

    /*
     * 渲染网页任务
     */
    public class RenderPageTask implements Callable<String> {

        /** 
         * @return
         * @throws Exception
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));

            String page = renderBody();

            // 将发生死锁-----由于任务在等待子任务的结果
            return header.get() + page + footer.get();
        }

        /**
         *
         * @return
         */
        private String renderBody() {
            return null;
        }

    }

}
