/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 没有投币的状态
 * @author wxh
 * @version $Id: NoQuarterState.java, v 0.1 2017年6月6日 下午3:46:10 wxh Exp $
 */
public class NoQuarterState implements State {

    GumballMachineNew gumballMachine;

    /**
     * @param gumballMachine
     */
    public NoQuarterState(GumballMachineNew gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    /** 
     * 
     * @see com.wxh.designmode.State#insertQuarter()
     */
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    /** 
     * 
     * @see com.wxh.designmode.State#ejectQuarter()
     */
    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#turnCrank()
     */
    @Override
    public void turnCrank() {
        System.out.println("You turned,but there's no quarter");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#dispense()
     */
    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

}
