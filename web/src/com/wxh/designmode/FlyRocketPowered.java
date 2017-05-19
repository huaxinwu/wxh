/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: FlyRocketPowered.java, v 0.1 2017年1月20日 上午10:15:34 wxh Exp $
 */
public class FlyRocketPowered implements FlyBehavior {

    /** 
     * 
     * @see com.wxh.designmode.FlyBehavior#fly()
     */
    @Override
    public void fly() {
        System.out.println("I am flying with a rocket......");

    }

}
