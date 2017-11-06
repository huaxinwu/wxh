/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 基于线程池web服务器
 * @author wxh
 * @version $Id: TaskExecutionWebServer.java, v 0.1 2017年10月31日 上午10:27:46 wxh Exp $
 */
public class TaskExecutionWebServer {

    private static final int      NTHREADS = 100;
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {

                @Override
                public void run() {
                    handleRequest(connection);
                }

                private void handleRequest(Socket connection) {
                }
            };
            EXECUTOR.execute(task);
        }
    }
}
