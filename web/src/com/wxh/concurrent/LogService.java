/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 通过注册一个关闭钩子来停止日志服务
 * ShutdownHook-- 关闭钩子
 * @author wxh
 * @version $Id: LogService.java, v 0.1 2017年11月3日 上午10:09:20 wxh Exp $
 */
public class LogService {

    public void start() {
        // 获取当前运行
        Runtime.getRuntime().addShutdownHook(new Thread() {
            /** 
             * 
             */
            @Override
            public void run() {
                try {
                    LogService.this.stop();
                } catch (InterruptedException e) {

                }
            }
        });
    }

    /**
     * 停止服务
     */
    protected void stop() throws InterruptedException {
    }
}
