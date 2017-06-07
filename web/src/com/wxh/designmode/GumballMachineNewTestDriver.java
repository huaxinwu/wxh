/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: GumballMachineNewTestDriver.java, v 0.1 2017年6月6日 下午4:53:22 wxh Exp $
 */
public class GumballMachineNewTestDriver {

    public static void main(String[] args) {
        GumballMachineNew gumballMachine = new GumballMachineNew(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

    }
}
