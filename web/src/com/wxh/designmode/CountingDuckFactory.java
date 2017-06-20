/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 计数器
 * @author wxh
 * @version $Id: CountingDuckFactory.java, v 0.1 2017年6月19日 下午4:19:25 wxh Exp $
 */
public class CountingDuckFactory extends AbstractDuckFactory {

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createMallardDuck()
     */
    @Override
    public Quackable createMallardDuck() {
        return new QuaclCounter(new ImplMallardDuck());
    }

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createRedheadDuck()
     */
    @Override
    public Quackable createRedheadDuck() {
        return new QuaclCounter(new ImplRedheadDuck());
    }

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createDuckCall()
     */
    @Override
    public Quackable createDuckCall() {
        return new QuaclCounter(new DuckCall());
    }

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createRubberDuck()
     */
    @Override
    public Quackable createRubberDuck() {
        return new QuaclCounter(new RubberDuck());
    }

}
