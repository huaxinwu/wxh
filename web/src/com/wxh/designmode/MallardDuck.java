/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: MallardDuck.java, v 0.1 2017年1月19日 下午1:45:41 wxh Exp $
 */
public class MallardDuck extends Duck {
    /**
     *  实例化接口
     */
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
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
        System.out.println("我是绿头的鸭子！");
    }

    /** 
     * 
     * @see com.wxh.designmode.Duck#performQuack()
     */
    @Override
    void quack() {
    }

    /** 
     * 
     * @see com.wxh.designmode.Duck#performFly()
     */
    @Override
    void fly() {
    }

}
