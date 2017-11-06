/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程服务器
 * @author wxh
 * @version $Id: SingleThreadServer.java, v 0.1 2017年10月30日 下午3:28:55 wxh Exp $
 */
public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket sockert = new ServerSocket(80);
        while (true) {
            Socket connection = sockert.accept();
            handleRequest(connection);
        }
    }

    /**
     *
     * @param connection
     */
    private static void handleRequest(Socket connection) {
    }

}
