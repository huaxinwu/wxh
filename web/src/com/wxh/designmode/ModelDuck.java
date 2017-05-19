/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: ModelDuck.java, v 0.1 2017年1月20日 上午10:13:24 wxh Exp $
 */
public class ModelDuck extends Duck {

    /**
     * 实例化参数、对象
     */
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    /** 
     * 
     * @see com.wxh.designmode.Duck#quack()
     */
    @Override
    void quack() {
    }

    /** 
     * 
     * @see com.wxh.designmode.Duck#fly()
     */
    @Override
    void fly() {
    }

    /** 
     * 
     * @see com.wxh.designmode.Duck#swim()
     */
    @Override
    void swim() {
    }

    /** 
     * 
     * @see com.wxh.designmode.Duck#dispaly()
     */
    @Override
    void dispaly() {
        System.out.println("I am a model duck......");
    }

}
