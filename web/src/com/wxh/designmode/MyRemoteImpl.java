/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程接口对象实现
 * @author wxh
 * @version $Id: MyRemoteImpl.java, v 0.1 2017年6月13日 上午10:53:20 wxh Exp $
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    /** */
    private static final long serialVersionUID = 2588531607900739115L;

    /**
     * UnicastRemoteObject 构造器抛出RemoteException异常，
     * 这里构造器页必须抛出RemoteException异常
     * @throws RemoteException
     */
    public MyRemoteImpl() throws RemoteException {

    }

    /** 
     * @return
     * @throws RemoteException
     * @see com.wxh.designmode.MyRemote#sayHello()
     */
    @Override
    public String sayHello() throws RemoteException {
        return "Server says,'Hey'";
    }

}
