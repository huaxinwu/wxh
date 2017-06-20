/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 鸭子工厂
 * @author wxh
 * @version $Id: DuckFactory.java, v 0.1 2017年6月19日 下午4:16:31 wxh Exp $
 */
public class DuckFactory extends AbstractDuckFactory {

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createMallardDuck()
     */
    @Override
    public Quackable createMallardDuck() {
        return new ImplMallardDuck();
    }

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createRedheadDuck()
     */
    @Override
    public Quackable createRedheadDuck() {
        return new ImplRedheadDuck();
    }

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createDuckCall()
     */
    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    /** 
     * @return
     * @see com.wxh.designmode.AbstractDuckFactory#createRubberDuck()
     */
    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

}
