/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: Quack.java, v 0.1 2017年1月20日 上午9:44:57 wxh Exp $
 */
public class Quack implements QuackBehavior {

    /** 
     * 
     * @see com.wxh.designmode.QuackBehavior#quack()
     */
    @Override
    public void quack() {
        System.out.println("quack......");
    }

}
