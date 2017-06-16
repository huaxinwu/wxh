/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.Naming;

/**
 * 客户端辅助对象
 * @author wxh
 * @version $Id: MyRemoteClient.java, v 0.1 2017年6月13日 上午11:05:50 wxh Exp $
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        try {
            // 从注册表查找服务
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1:8888/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
