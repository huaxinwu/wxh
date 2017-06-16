/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 糖果机远程接口
 * @author wxh
 * @version $Id: GumballMachineRemote.java, v 0.1 2017年6月13日 上午11:21:59 wxh Exp $
 */
public interface GumballMachineRemote extends Remote {
    // 所有的返回类型必须是原语类型或者是可序列化类型
    public int getCount() throws RemoteException;

    public String getLocation() throws RemoteException;

    public State getState() throws RemoteException;

}
