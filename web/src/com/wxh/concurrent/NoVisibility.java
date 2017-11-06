/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 不可见性(不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: NoVisibility.java, v 0.1 2017年10月24日 下午3:00:05 wxh Exp $
 */
public class NoVisibility {
    private static boolean ready;
    private static int     number;

    /*
     * 可读线程
     */
    private static class ReaderThread extends Thread {
        /** 
         * 
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        // 开启一个线程
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
