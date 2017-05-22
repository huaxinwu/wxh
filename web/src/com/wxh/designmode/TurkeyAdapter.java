/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 封装一个适配器来实现鸭子接口，通过构造器来适配对象
 * @author wxh
 * @version $Id: TurkeyAdapter.java, v 0.1 2017年5月22日 上午10:26:56 wxh Exp $
 */
public class TurkeyAdapter implements DuckInterface {
    Turkey turkey;

    /**
     * 作为参数来适配
     */
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    /** 
     * 
     * @see com.wxh.designmode.DuckInterface#quack()
     */
    @Override
    public void quack() {
        turkey.gobble();
    }

    /** 
     * 飞行五次来达到鸭子的飞行距离
     * @see com.wxh.designmode.DuckInterface#fly()
     */
    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

}
