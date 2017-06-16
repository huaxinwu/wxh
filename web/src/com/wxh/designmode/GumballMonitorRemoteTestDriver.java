/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.Naming;

/**
 * RMI 测试：监控器
 * 客户端
 * @author wxh
 * @version $Id: GumballMonitorRemoteTestDriver.java, v 0.1 2017年6月13日 上午11:46:40 wxh Exp $
 */
public class GumballMonitorRemoteTestDriver {

    public static void main(String[] args) {
        String[] locations = { "rmi://127.0.0.1:8888/gumballMachine",
                "rmi://127.0.0.1:8888/gumballMachine", "rmi://127.0.0.1:8888/gumballMachine" };

        GumballMonitor[] monitors = new GumballMonitor[locations.length];
        for (int i = 0; i < locations.length; i++) {
            try {
                GumballMachineRemote machineRemote = (GumballMachineRemote) Naming
                    .lookup(locations[i]);
                monitors[i] = new GumballMonitor(machineRemote);
                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 打印每个监控器
        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}
