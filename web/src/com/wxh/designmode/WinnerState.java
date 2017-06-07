/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;


/**
 *
 * @author wxh
 * @version $Id: WinnerState.java, v 0.1 2017年6月6日 下午4:44:12 wxh Exp $
 */
public class WinnerState implements State {

    GumballMachineNew gumballMachine;

    /**
     * @param gumballMachine
     */
    public WinnerState(GumballMachineNew gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    /** 
     * 
     * @see com.wxh.designmode.State#insertQuarter()
     */
    @Override
    public void insertQuarter() {
        System.out.println("Please wait,we're already giving you a gumaball");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#ejectQuarter()
     */
    @Override
    public void ejectQuarter() {
        System.out.println("Sorry,you already turned the crank");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#turnCrank()
     */
    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#dispense()
     */
    @Override
    public void dispense() {
        System.out.println("YOU'RE A WINNER! You get gumballs for your quarter");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops,out of gumball!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }

        }
    }

}
