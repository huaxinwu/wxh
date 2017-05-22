/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 野生火鸡
 * @author wxh
 * @version $Id: WildTurkey.java, v 0.1 2017年5月22日 上午10:17:56 wxh Exp $
 */
public class WildTurkey implements Turkey {

    /** 
     * 
     * @see com.wxh.designmode.Turkey#gobble()
     */
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    /** 
     * 
     * @see com.wxh.designmode.Turkey#fly()
     */
    @Override
    public void fly() {
        System.out.println("I am flying a short distance");
    }

}
