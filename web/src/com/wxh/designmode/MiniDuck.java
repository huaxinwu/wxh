/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 测试设计模式的案例
 * @author wxh
 * @version $Id: MiniDuck.java, v 0.1 2017年1月20日 上午9:50:42 wxh Exp $
 */
public class MiniDuck {
    public static void main(String[] agrs) {

        /**
         * 以构造器方式实例化鸭子行为
         */
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        System.out.println("---------------------------");

        /**
         * 以setter方法实例化鸭子行为
         */
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

    }

}
