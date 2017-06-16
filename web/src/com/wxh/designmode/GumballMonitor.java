/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.RemoteException;

/**
 * 设计模式十四:代理模式(为另一个对象提供一个替身或占位符以控制对这个对象的访问。)
 * 糖果监视器应用：用户监视糖果机分配糖果情况
 * 代理控制访问的方式：
 * 1.远程代理控制访问远程对象
 * 2.虚拟代理控制访问创建开销大的资源
 * 3.保护代理基于权限控制对资源的访问
 * RMI(remote method interface)远程方法调用
 * @author wxh
 * @version $Id: GumballMonitor.java, v 0.1 2017年6月7日 上午11:36:01 wxh Exp $
 */
public class GumballMonitor {
    //    GumballMachineNew    machine;
    GumballMachineRemote machine;

    /**
     * @param gumballMachine
     */
    public GumballMonitor(GumballMachineRemote machine) {
        super();
        this.machine = machine;
    }

    /**
     * @param gumballMachine
     */
    //    public GumballMonitor(GumballMachineNew machine) {
    //        super();
    //        this.machine = machine;
    //    }

    /**
     * 打印报告(位置、库存、状态)
     */
    public void report() {
        try {
            System.out.println("Gumball Machine:" + machine.getLocation());
            System.out.println("Current inventory:" + machine.getCount() + " gumballs");
            System.out.println("Current state:" + machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
