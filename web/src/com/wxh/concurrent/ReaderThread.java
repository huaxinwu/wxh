/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 通过改写interrupt方法将非标准的取消操作封装在Thread中
 * @author wxh
 * @version $Id: ReaderThread.java, v 0.1 2017年11月2日 上午11:10:54 wxh Exp $
 */
public class ReaderThread extends Thread {
    private final Socket      client;
    private final InputStream is;

    public ReaderThread(Socket client) throws IOException {
        this.client = client;
        this.is = client.getInputStream();

    }

    /**
     * 重写interrupt方法
     * 
     */
    @Override
    public void interrupt() {
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }
    }

    /** 
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                byte[] buf = new byte[1024];
                int count = is.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    processBuffee(buf, count);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param buf
     * @param count
     */
    private void processBuffee(byte[] buf, int count) {
    }
}
