/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *  低咖啡因咖啡
 * @author wxh
 * @version $Id: Decaf.java, v 0.1 2017年4月17日 下午1:57:18 wxh Exp $
 */
public class Decaf extends Beverage {
    /**
     * 
     */
    public Decaf() {
        description = "Decaf Coffee";
    }

    /** 
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return 1.05;
    }

}
