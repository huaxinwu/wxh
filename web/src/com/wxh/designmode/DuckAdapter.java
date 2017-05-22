/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 鸭子适配器
 * @author wxh
 * @version $Id: DuckAdapter.java, v 0.1 2017年5月22日 上午11:22:23 wxh Exp $
 */
public class DuckAdapter implements Turkey {
    DuckInterface duck;

    /**
     * 
     */
    public DuckAdapter(DuckInterface duck) {
        this.duck = duck;
    }

    /** 
     * 
     * @see com.wxh.designmode.Turkey#gobble()
     */
    @Override
    public void gobble() {
        duck.quack();
    }

    /** 
     * 
     * @see com.wxh.designmode.Turkey#fly()
     */
    @Override
    public void fly() {
    }

}
