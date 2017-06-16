/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * jdk1.1 就有了RMI
 * 定义一个远程接口，继承Remote接口，其中调用的方法必须抛出RemoteException异常 
 * @author wxh
 * @version $Id: IHello.java, v 0.1 2017年6月13日 上午10:06:52 wxh Exp $
 */
public interface IHello extends Remote {
    /**
     * 返回"hello world!"字样的字符串
     * @return String
     * @throws RemoteException
     */
    public String helloWorld() throws RemoteException;

    /**
     * 通过传入一个参数，获取一个字符串
     * @param someBodyName
     * @return String
     * @throws RemoteException
     */
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException;
}
