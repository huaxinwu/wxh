/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: FlyWithWings.java, v 0.1 2017年1月20日 上午9:43:21 wxh Exp $
 */
public class FlyWithWings implements FlyBehavior {

    /** 
     * 
     * @see com.wxh.designmode.FlyBehavior#fly()
     */
    @Override
    public void fly() {
        System.out.println("I'm flying......");
    }

}
