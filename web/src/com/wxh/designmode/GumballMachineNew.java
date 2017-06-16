/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 糖果机--成员变量都有接口声明
 * @author wxh
 * @version $Id: GumballMachineNew.java, v 0.1 2017年6月6日 下午4:03:49 wxh Exp $
 */
public class GumballMachineNew extends UnicastRemoteObject implements GumballMachineRemote {
    State  soldOutState;
    State  noQuarterState;
    State  hasQuarterState;
    State  soldState;
    State  winnerState;
    State  state = soldOutState;
    int    count = 0;
    /** 位置  */
    String location;

    public GumballMachineNew() throws RemoteException {

    }

    /**
     *  在构造器初始化所有的状态(位置)
     * @throws RemoteException 
     */
    public GumballMachineNew(String location, int numberGumballs) throws RemoteException {
        super();
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        this.location = location;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    /**
     *  在构造器初始化所有的状态
     * @throws RemoteException 
     */
    public GumballMachineNew(int numberGumballs) throws RemoteException {
        super();
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        // 分配糖果是个内部方法
        state.dispense();
    }

    /**
     * 设置状态
     * @param state
     */
    void setState(State state) {
        this.state = state;
    }

    /**
     * 释放糖果
     */
    void releaseBall() {
        System.out.println("A gumball comes rolling out the solt ...");
        if (count != 0) {
            count = count - 1;
        }
    }

    /**
     * 填充糖果
     */
    void refill() {
        this.count = count;
        state = noQuarterState;
    }

    public String getLocation() {
        return location;
    }

    /**
     * Getter method for property <tt>soldOutState</tt>.
     * 
     * @return property value of soldOutState
     */
    public State getSoldOutState() {
        return soldOutState;
    }

    /**
     * Getter method for property <tt>noQuarterState</tt>.
     * 
     * @return property value of noQuarterState
     */
    public State getNoQuarterState() {
        return noQuarterState;
    }

    /**
     * Getter method for property <tt>hasQuarterState</tt>.
     * 
     * @return property value of hasQuarterState
     */
    public State getHasQuarterState() {
        return hasQuarterState;
    }

    /**
     * Getter method for property <tt>soldState</tt>.
     * 
     * @return property value of soldState
     */
    public State getSoldState() {
        return soldState;
    }

    /**
     * Getter method for property <tt>winnerState</tt>.
     * 
     * @return property value of winnerState
     */
    public State getWinnerState() {
        return winnerState;
    }

    /**
     * Getter method for property <tt>state</tt>.
     * 
     * @return property value of state
     */
    public State getState() {
        return state;
    }

    /**
     * Getter method for property <tt>count</tt>.
     * 
     * @return property value of count
     */
    public int getCount() {
        return count;
    }

    /** 
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Mighty Gumball,Inc.\nJava-enabled Standing Gumball Model #2004\nInventory:"
               + (count) + " gumballs\nMachine is waiting for quarter\n";
    }

}
