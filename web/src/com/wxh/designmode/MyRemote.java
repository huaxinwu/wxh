/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口对象声明，并继承Remote接口
 * @author wxh
 * @version $Id: MyRemote.java, v 0.1 2017年6月13日 上午10:47:33 wxh Exp $
 */
public interface MyRemote extends Remote {

    /**
     * 获取一个字符串
     * @return
     * @throws RemoteException
     */
    public String sayHello() throws RemoteException;
}
