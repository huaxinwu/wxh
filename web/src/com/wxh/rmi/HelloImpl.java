/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程接口的实现
 * @author wxh
 * @version $Id: HelloImpl.java, v 0.1 2017年6月13日 上午10:14:26 wxh Exp $
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
    /** */
    private static final long serialVersionUID = -4866094880051449480L;

    /**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，
     * 因此这里默认的构造方法必须写，必须声明抛出RemoteException异常 
     * @throws RemoteException
     */
    public HelloImpl() throws RemoteException {
    }

    /** 
     * @return String
     * @throws RemoteException
     * @see com.wxh.rmi.IHello#helloWorld()
     */
    @Override
    public String helloWorld() throws RemoteException {
        return "Hello World!";
    }

    /** 
     * @param someBodyName
     * @return String
     * @throws RemoteException
     * @see com.wxh.rmi.IHello#sayHelloToSomeBody(java.lang.String)
     */
    @Override
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
        return "您好," + someBodyName + "!";
    }

}
