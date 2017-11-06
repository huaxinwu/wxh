/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 错误Time行为,最好的办法是：使用时延队列处理
 * @author wxh
 * @version $Id: OutOfTime.java, v 0.1 2017年10月31日 上午11:04:11 wxh Exp $
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        TimeUnit.SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 2);
        TimeUnit.SECONDS.sleep(5);
    }

    private static class ThrowTask extends TimerTask {

        /** 
         * 
         * @see java.util.TimerTask#run()
         */
        @Override
        public void run() {
            throw new RuntimeException();
        }

    }

}
