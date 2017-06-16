/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Random;

/**
 *
 * @author wxh
 * @version $Id: HasQuarterState.java, v 0.1 2017年6月6日 下午4:11:37 wxh Exp $
 */
public class HasQuarterState implements State {
    // 随机数
    Random                      randomWinner = new Random(System.currentTimeMillis());

    transient GumballMachineNew gumballMachine;

    /**
     * @param gumballMachine
     */
    public HasQuarterState(GumballMachineNew gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    /** 
     * 
     * @see com.wxh.designmode.State#insertQuarter()
     */
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    /** 
     * 
     * @see com.wxh.designmode.State#ejectQuarter()
     */
    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    /** 
     * 
     * @see com.wxh.designmode.State#turnCrank()
     */
    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        // 该值介于[0,10)的区间，包含0不包含10
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    /** 
     * 
     * @see com.wxh.designmode.State#dispense()
     */
    @Override
    public void dispense() {
        System.out.println("No gumball dispense");
    }

}
