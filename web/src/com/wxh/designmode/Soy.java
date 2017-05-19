/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 豆浆
 * @author wxh
 * @version $Id: Soy.java, v 0.1 2017年4月17日 下午2:17:09 wxh Exp $
 */
public class Soy extends CondimentDecorator {
    /** 用一个实例变量来记录饮料--被装饰者 */
    Beverage beverage;

    /**
     * 
     */
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    /** 
     * @return
     * @see com.wxh.designmode.CondimentDecorator#getDescription()
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    /** 
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return .15 + beverage.cost();
    }

}
