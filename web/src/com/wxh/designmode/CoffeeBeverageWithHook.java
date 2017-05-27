/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 带挂钩的咖啡因饮料
 * @author wxh
 * @version $Id: CoffeeBeverageWithHook.java, v 0.1 2017年5月27日 上午11:00:58 wxh Exp $
 */
public abstract class CoffeeBeverageWithHook {
    /**
     * 准备食谱
     */
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // 顾客想要调料，菜加入调料
        if (customrWantsCondiments()) {
            addCondiments();
        }
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

    /**
     * 顾客是否想要调料
     * @return
     */
    boolean customrWantsCondiments() {
        return true;
    }
}
