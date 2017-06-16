/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端
 * 在客户端调用远程对象上的方法，并返回结果
 * @author wxh
 * @version $Id: HelloClient.java, v 0.1 2017年6月13日 上午10:30:06 wxh Exp $
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            // 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            IHello rHello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");

            System.out.println(rHello.helloWorld());
            System.out.println(rHello.sayHelloToSomeBody("亚索"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
