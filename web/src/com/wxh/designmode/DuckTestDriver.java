/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;


/**
 * 测试适配器
 * @author wxh
 * @version $Id: DuckTestDriver.java, v 0.1 2017年5月22日 上午10:38:06 wxh Exp $
 */
public class DuckTestDriver {

    public static void main(String[] args) {
        // 创建一只鸭子
        MallardDuckImpl duck = new MallardDuckImpl();
        // 创建一只火鸡
        WildTurkey turkey = new WildTurkey();

        DuckInterface turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("The Turkeys says....");
        turkey.gobble();
        turkey.fly();
        System.out.println("\nThe Ducks says.....");
        testDuck(duck);
        System.out.println("\nThe TurkeyAdapter says....");
        testDuck(turkeyAdapter);

    }

    static void testDuck(DuckInterface duck) {
        duck.quack();
        duck.fly();
    }
}
