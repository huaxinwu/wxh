/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

/**
 * 基于SwingUtilities构建Executor(执行者)
 * @author wxh
 * @version $Id: GuiExecutor.java, v 0.1 2017年11月6日 上午10:50:28 wxh Exp $
 */
public class GuiExecutor extends AbstractExecutorService {

    // 采用单件模式:一个私有构造器和一个公共工厂方法
    private static final GuiExecutor INSTANCE = new GuiExecutor();

    private GuiExecutor() {

    }

    public static GuiExecutor instance() {
        return INSTANCE;
    }

    /** 
     * 
     * @see java.util.concurrent.ExecutorService#shutdown()
     */
    @Override
    public void shutdown() {
    }

    /** 
     * @return
     * @see java.util.concurrent.ExecutorService#shutdownNow()
     */
    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    /** 
     * @return
     * @see java.util.concurrent.ExecutorService#isShutdown()
     */
    @Override
    public boolean isShutdown() {
        return false;
    }

    /** 
     * @return
     * @see java.util.concurrent.ExecutorService#isTerminated()
     */
    @Override
    public boolean isTerminated() {
        return false;
    }

    /** 
     * @param timeout
     * @param unit
     * @return
     * @throws InterruptedException
     * @see java.util.concurrent.ExecutorService#awaitTermination(long, java.util.concurrent.TimeUnit)
     */
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /** 
     * @param command
     * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
     */
    @Override
    public void execute(Runnable command) {
        if (SwingUtilities.isEventDispatchThread()) {
            command.run();
        } else {
            SwingUtilities.invokeLater(command);
        }
    }

}
