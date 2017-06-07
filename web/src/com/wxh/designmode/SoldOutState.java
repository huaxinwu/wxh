/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: SoldOutState.java, v 0.1 2017年6月6日 下午4:11:20 wxh Exp $
 */
public class SoldOutState implements State {

    GumballMachineNew gumballMachine;

    /**
     * @param gumballMachine
     */
    public SoldOutState(GumballMachineNew gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    /** 
     * 
     * @see com.wxh.designmode.State#insertQuarter()
     */
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter,the machine is sold out");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#ejectQuarter()
     */
    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject,you haven't inserted a quarter yet");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#turnCrank()
     */
    @Override
    public void turnCrank() {
        System.out.println("You turned, but there no gumball");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#dispense()
     */
    @Override
    public void dispense() {
        System.out.println("No gumabll dispensed");
    }

}
