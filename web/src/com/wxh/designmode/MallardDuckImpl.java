/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: MallardDuckImpl.java, v 0.1 2017年5月22日 上午10:47:04 wxh Exp $
 */
public class MallardDuckImpl implements DuckInterface {

    /** 
     * 
     * @see com.wxh.designmode.DuckInterface#quack()
     */
    @Override
    public void quack() {
        System.out.println("mallard duck quack");
    }

    /** 
     * 
     * @see com.wxh.designmode.DuckInterface#fly()
     */
    @Override
    public void fly() {
        System.out.println("mallard duck flying");
    }

}
