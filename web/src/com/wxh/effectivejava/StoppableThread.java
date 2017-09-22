/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 阻止线程
 * 实现线程两种方法：1.继承Thread类,2.实现Runnable接口
 * 
 * @author wxh
 * @version $Id: StoppableThread.java, v 0.1 2017年9月20日 下午3:18:36 wxh Exp $
 */
public class StoppableThread extends Thread {

    /** 停止请求  */
    private boolean stopRequested = false;

    /**
     * 没有同步，不能保证这个可终止的线程将会看到其他线程对stopRequested的改变
     * 解决方法：对访问stopRequested方法都加同步特性synchronized
     * 
     */
    @Override
    public void run() {
        boolean done = false;
        // 没有停止请求并且没有开始做
        while (!stopRequested && done) {
            // do what needs to done
        }
    }

    /**
     * 请求停止
     */
    public void requestStop() {
        stopRequested = true;
    }

    /**
     * 解决方法：对访问stopRequested方法都加同步特性synchronized
     */
    public synchronized void requestStop2() {
        stopRequested = true;
    }

    /**
     * 解决方法：对访问stopRequested方法都加同步特性synchronized
     * @return boolean 布尔
     */
    public synchronized boolean stopRequested() {
        return stopRequested;
    }

}
