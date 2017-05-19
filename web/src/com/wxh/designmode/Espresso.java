/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 浓缩咖啡
 * @author wxh
 * @version $Id: Espresso.java, v 0.1 2017年4月17日 上午11:31:09 wxh Exp $
 */
public class Espresso extends Beverage {
    /**
     * 默认构造器,覆盖来自继承的变量值
     */
    public Espresso() {
        description = "Espresso";
    }

    /** 
     * 暂时设定固定值
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return 1.99;
    }

}
