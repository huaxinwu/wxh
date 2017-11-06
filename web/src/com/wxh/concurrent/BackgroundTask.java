/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 支持取消，完成通知以及进度通知的后台任务
 * @author wxh
 * @version $Id: BackgroundTask.java, v 0.1 2017年11月6日 上午10:41:44 wxh Exp $
 */
public abstract class BackgroundTask<V> implements Runnable, Future<V> {
    private final FutureTask<V> computation = new Computation();

    private class Computation extends FutureTask<V> {

        /**
         * @param callable
         */
        public Computation() {
            super(new Callable<V>() {

                @Override
                public V call() throws Exception {
                    return BackgroundTask.this.compute();
                }

            });
        }

        protected final void done() {
            GuiExecutor.instance().execute(new Runnable() {

                @Override
                public void run() {
                    V value = null;
                    Throwable thrown = null;
                    boolean cancelled = false;
                    try {
                        value = get();
                    } catch (ExecutionException e) {
                        thrown = e.getCause();
                    } catch (CancellationException e) {
                        cancelled = true;
                    } catch (InterruptedException e) {
                    } finally {
                        onCompletion(value, thrown, cancelled);
                    }
                }
            });
        }

    }

    /**
    * 在事件线程被取消
    * @param value
    * @param thrown
    * @param cancelled
    */
    protected void onCompletion(V value, Throwable thrown, boolean cancelled) {
    }

    /**
     * 设置进度条
     * @param current
     * @param max
     */
    protected void setProgress(final int current, final int max) {
        GuiExecutor.instance().execute(new Runnable() {

            @Override
            public void run() {
                onProgress(current, max);
            }
        });
    }

    /**
    * 进度条通知
    * @param current
    * @param max
    */
    protected void onProgress(int current, int max) {

    }

    /**
     * 在后台线程被取消
     * @return
     */
    protected abstract V compute();
}
