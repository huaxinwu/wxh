/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * socket client
 * @author wxh
 * @version $Id: MyClient.java, v 0.1 2016年12月8日 下午1:43:33 wxh Exp $
 */
public class MyClient {
    static Socket client;

    public static void main(String[] args) throws Exception {
        client = new Socket(InetAddress.getLocalHost(), 5678);
        PrintWriter out = new PrintWriter(client.getOutputStream());
        BufferedReader buff = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true) {
            String string = buff.readLine();
            out.println("has recevie...");
            out.flush();
            if (string.equals("end")) {
                break;
            }
        }
        client.close();
    }
}
