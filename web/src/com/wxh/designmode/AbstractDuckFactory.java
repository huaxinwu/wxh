/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 抽象工厂
 * @author wxh
 * @version $Id: AbstractDuckFactory.java, v 0.1 2017年6月19日 下午4:13:05 wxh Exp $
 */
public abstract class AbstractDuckFactory {

    /**
     * 创建绿头鸭
     * @return
     */
    public abstract Quackable createMallardDuck();

    /**
     * 创建红头鸭
     * @return
     */
    public abstract Quackable createRedheadDuck();

    /**
     * 创建鸭鸣器
     * @return
     */
    public abstract Quackable createDuckCall();

    /**
     * 创建橡皮鸭
     * @return
     */
    public abstract Quackable createRubberDuck();
}
