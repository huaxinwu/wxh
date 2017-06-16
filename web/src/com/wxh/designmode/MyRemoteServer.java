/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 服务器辅助对象
 * @author wxh
 * @version $Id: MyRemoteServer.java, v 0.1 2017年6月13日 上午11:04:58 wxh Exp $
 */
public class MyRemoteServer {

    public static void main(String[] args) {
        // 创建远程接口对象
        try {
            MyRemote service = new MyRemoteImpl();
            // 注册服务
            LocateRegistry.createRegistry(8888);
            // rmi://127.0.0.1:1099/RemoteHello
            Naming.bind("rmi://127.0.0.1:8888/RemoteHello", service);
            System.out.println(">>>  INFO:远程MyRemote对象绑定成功!    >>>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
