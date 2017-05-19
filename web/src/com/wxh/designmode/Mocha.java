/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 摩卡
 * @author wxh
 * @version $Id: Mocha.java, v 0.1 2017年4月17日 下午2:08:27 wxh Exp $
 */
public class Mocha extends CondimentDecorator {
    /** 用一个实例变量来记录饮料--被装饰者 */
    Beverage beverage;

    /**
     * 想办法让被装饰者被记录到实例变量中
     */
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    /** 
     * @return
     * @see com.wxh.designmode.CondimentDecorator#getDescription()
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    /** 
     * 调料+饮料
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

}
