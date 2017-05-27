/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;


/**
 * 
 * 设计模式十：模板方法模式(在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。)
 * 冲咖啡冲茶应用：冲咖啡过程：把水煮沸，用沸水冲泡咖啡，把咖啡掉进杯子，加糖、牛奶；冲茶过程：把水煮沸，用沸水浸泡茶，把茶掉进杯子，加柠檬
 * 设计原则：好莱坞原则--别调用我们，我们会调用你的。
 * 底层组件调用高层组件，高层组件控制底层组件。
 * @author wxh
 * @version $Id: Coffee.java, v 0.1 2017年5月25日 下午2:29:33 wxh Exp $
 */
public class Coffee extends CoffeeBeverage {

    /**
     * 冲泡咖啡
     */
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    /**
     * 加糖、牛奶
     */
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

}
