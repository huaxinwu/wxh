/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 奶泡
 * @author wxh
 * @version $Id: Whip.java, v 0.1 2017年4月17日 下午2:19:41 wxh Exp $
 */
public class Whip extends CondimentDecorator {
    /** 用一个实例变量来记录饮料--被装饰者 */
    Beverage beverage;

    /**
     * 
     */
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    /** 
     * @return
     * @see com.wxh.designmode.CondimentDecorator#getDescription()
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

    /** 
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

}
