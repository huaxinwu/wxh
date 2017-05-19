/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: FlyNoWay.java, v 0.1 2017年1月20日 上午10:12:24 wxh Exp $
 */
public class FlyNoWay implements FlyBehavior {

    /** 
     * 
     * @see com.wxh.designmode.FlyBehavior#fly()
     */
    @Override
    public void fly() {
        System.out.println("I'm not flying......");
    }

}
