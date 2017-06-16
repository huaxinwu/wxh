/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.RemoteException;

/**
 * 测试糖果机监视器
 * @author wxh
 * @version $Id: GumballMonitorTestDriver.java, v 0.1 2017年6月7日 上午11:40:53 wxh Exp $
 */
public class GumballMonitorTestDriver {

    public static void main(String[] args) throws RemoteException {

        int count = 0;
        if (args.length < 2) {
            System.out.println("GumballMachine <name><inventory>");
            System.exit(1);
        }
        count = Integer.parseInt(args[1]);
        GumballMachineNew gumballMachine = new GumballMachineNew(args[0], count);

        //        GumballMachineNew gumballMachine = new GumballMachineNew("Seattle", 112);
        GumballMonitor monitor = new GumballMonitor(gumballMachine);
        // 其他测试代码

        monitor.report();

    }
}
