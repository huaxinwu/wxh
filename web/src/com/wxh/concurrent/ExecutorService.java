/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService中生命周期的管理方法(生命周期三种状态：运行、关闭，已经终止)
 * @author wxh
 * @version $Id: ExecutorService.java, v 0.1 2017年10月31日 上午10:21:16 wxh Exp $
 */
public interface ExecutorService extends Executor {

    /**
     * 关机
     */
    void shutdown();

    /**
     * 现在就关闭所有资源
     * @return
     */
    List<Runnable> shuidownNow();

    /**
     * 判断是否是关机
     * @return
     */
    boolean isShutdown();

    /**
     * 判断是否是终止
     * @return
     */
    boolean isTerminated();

    /**
     * 在某个是时间段等待终止
     * @param timeout
     * @param unit
     * @return
     * @throws InterruptedException
     */
    boolean awaitTerminated(long timeout, TimeUnit unit) throws InterruptedException;
    // .....其他方法
}
