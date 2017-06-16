/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * RMI 测试:糖果机
 * 服务器端
 * @author wxh
 * @version $Id: GumballMachineDriverTest.java, v 0.1 2017年6月13日 上午11:41:47 wxh Exp $
 */
public class GumballMachineRemoteTestDriver {

    public static void main(String[] args) throws Exception {

        GumballMachineNew gumballMachine = new GumballMachineNew("127.0.0.1", 100);
        // 其他测试代码
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://127.0.0.1:8888/gumballMachine", gumballMachine);
        System.out.println(">>>  INFO:远程gumballMachine对象绑定成功!    >>>");
    }
}
