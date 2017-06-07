/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式十三：状态模式(允许对象在内部状态时改变它的行为，对象看起来好像修改了它的类。)
 * 糖果机应用:投入25分钱，退回25分钱，转动曲柄，发放糖果
 * @author wxh
 * @version $Id: GumballMachine.java, v 0.1 2017年6月6日 上午10:45:31 wxh Exp $
 */
public class GumballMachine {
    /** 出售 */
    final static int SOLD_OUT    = 0;
    /** 没有25分钱   */
    final static int NO_QUARTER  = 1;
    /** 有25分钱  */
    final static int HAS_QUARTER = 2;
    /** 售馨(卖光) */
    final static int SOLD        = 3;
    /** 10%机率，可以得到两个糖果  */
    final static int WINNER      = 4;
    /** 追踪糖果的次数 */
    int              state       = SOLD_OUT;
    int              count       = 0;

    /**
     * 如果库存不为零，状态为没有25分钱
     */
    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 投入25分钱
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a quarter,the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait,we're already giving you a gumball");
        }
    }

    /**
     * 退回25分钱
     */
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("You can't inserted a quarter");
        } else if (state == SOLD) {
            System.out.println("Sorry,you already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject,you haven't inserted a quarter yet");
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball");
        } else if (state == NO_QUARTER) {
            System.out.println("You turned ,but there's no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there no gumball");
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    /**
     * 分配糖果
     */
    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops,out of gumball!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("You need pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumabll dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumabll dispensed");
        }
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
