/**
 * wxh Inc.
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
 * socket server
 * @author wxh
 * @version $Id: MyServer.java, v 0.1 2016年12月8日 下午1:43:09 wxh Exp $
 */
public class MyServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(5678);
        Socket client = server.accept();
        BufferedReader buff = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        while (true) {
            String string = buff.readLine();
            out.println("has receive....");
            out.flush();
            if (string.equals("end")) {
                break;
            }
        }
        client.close();
    }
}
