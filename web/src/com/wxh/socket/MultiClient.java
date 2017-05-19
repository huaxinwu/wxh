/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程 socket
 * @author wxh
 * @version $Id: MultiClient.java, v 0.1 2016年12月8日 下午2:00:33 wxh Exp $
 */
public class MultiClient extends Thread {
    private Socket client;

    public MultiClient(Socket c) {
        this.client = c;
    }

    /** 
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        super.run();
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream());
            BufferedReader buff = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true) {
                String string = buff.readLine();
                out.println("has receive...");
                out.flush();
                if (string.equals("end")) {
                    break;
                }
            }
            client.close();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {

        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        while (true) {
            MultiClient mClient = new MultiClient(server.accept());
            mClient.start();
        }
    }
}
