/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;


/**
 * 咖啡因饮料
 * 咖啡和茶：都有把水煮沸，导入杯子，其次冲泡，浸泡，加入饮料，因此抽离出抽象类，抽象方法
 * 模板方法定义了一个算法的步骤，并允许子类为一个或者多个步骤提供实现。
 * @author wxh
 * @version $Id: CoffeeBeverage.java, v 0.1 2017年5月27日 上午10:08:17 wxh Exp $
 */
public abstract class CoffeeBeverage {

    /**
     * 准备食谱
     * 不期望子类覆盖此方法
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     * 冲泡
     */
    abstract void brew();

    /**
     * 添加调料
     */
    abstract void addCondiments();

    /**
     * 把水煮沸
     */
    public void boilWater() {
        System.out.println("Boiling Water");
    }

    /**
     * 导入杯子
     */
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

}
