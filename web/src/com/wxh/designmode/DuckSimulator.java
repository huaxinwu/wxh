/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 鸭子模拟器
 * @author wxh
 * @version $Id: DuckSimulator.java, v 0.1 2017年6月19日 上午10:14:18 wxh Exp $
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        // 非static方法，可以通过对象调用
        //        simulator.simulator();
        simulator.simulator(duckFactory);
    }

    /**
     * 工厂对象作为参数
     * 模拟鸭子(绿头鸭，红头鸭、鸭鸣器、橡皮鸭)
     */
    void simulator(AbstractDuckFactory duckFactory) {

        /**
         * 工厂模式来构造对象
         */
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        Flock flockOfDucks = new Flock();
        /**
         * 添加红头鸭、鸭鸣器、橡皮鸭、鹅
         */
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        /**
         * 添加绿头鸭
         */
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        /**
         * 将绿头鸭加入主群
         */
        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: With Obsever");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        /**
         * 测试一群鸭子
         */
        simulator(flockOfDucks);

        System.out.println("The ducks quacked " + QuaclCounter.getQuacks() + " times");

    }

    /**
     * 工厂对象作为参数
     * 模拟鸭子(绿头鸭，红头鸭、鸭鸣器、橡皮鸭)
     */
    //    void simulator(AbstractDuckFactory duckFactory) {
    //
    //        /**
    //         * 工厂模式来构造对象
    //         */
    //        Quackable redheadDuck = duckFactory.createRedheadDuck();
    //        Quackable duckCall = duckFactory.createDuckCall();
    //        Quackable rubberDuck = duckFactory.createRubberDuck();
    //        /**
    //         * 适配器模式来构造对象
    //         */
    //        Quackable gooseDuck = new GooseAdapter(new Goose());
    //
    //        System.out.println("\nDuck Simulator: With Composite -  Flocks");
    //
    //        Flock flockOfDucks = new Flock();
    //        /**
    //         * 添加红头鸭、鸭鸣器、橡皮鸭、鹅
    //         */
    //        flockOfDucks.add(redheadDuck);
    //        flockOfDucks.add(duckCall);
    //        flockOfDucks.add(rubberDuck);
    //        flockOfDucks.add(gooseDuck);
    //
    //        Flock flockOfMallards = new Flock();
    //        Quackable mallardOne = duckFactory.createMallardDuck();
    //        Quackable mallardTwo = duckFactory.createMallardDuck();
    //        Quackable mallardThree = duckFactory.createMallardDuck();
    //        Quackable mallardFour = duckFactory.createMallardDuck();
    //
    //        /**
    //         * 添加绿头鸭
    //         */
    //        flockOfMallards.add(mallardOne);
    //        flockOfMallards.add(mallardTwo);
    //        flockOfMallards.add(mallardThree);
    //        flockOfMallards.add(mallardFour);
    //
    //        /**
    //         * 将绿头鸭加入主群
    //         */
    //        flockOfDucks.add(flockOfMallards);
    //
    //        System.out.println("\nDuck Simulator: Whole Flock Simulator");
    //
    //        /**
    //         * 测试一群鸭子
    //         */
    //        simulator(flockOfDucks);
    //
    //        System.out.println("\nDuck Simulator: Mallard Flock Simulator");
    //
    //        /**
    //         * 测试一群绿头鸭子
    //         */
    //        simulator(flockOfMallards);
    //
    //        System.out.println("The ducks quacked " + QuaclCounter.getQuacks() + " times");
    //
    //    }

    /**
     * 工厂对象作为参数
     * 模拟鸭子(绿头鸭，红头鸭、鸭鸣器、橡皮鸭)
     */
    //    void simulator(AbstractDuckFactory duckFactory) {
    //
    //        /**
    //         * 工厂模式来构造对象
    //         */
    //        Quackable mallardDuck = duckFactory.createMallardDuck();
    //        Quackable redheadDuck = duckFactory.createRedheadDuck();
    //        Quackable duckCall = duckFactory.createDuckCall();
    //        Quackable rubberDuck = duckFactory.createRubberDuck();
    //        /**
    //         * 适配器模式来构造对象
    //         */
    //        Quackable gooseDuck = new GooseAdapter(new Goose());
    //
    //        System.out.println("\nDuck Simulator: With Abstract Factory");
    //
    //        simulator(mallardDuck);
    //        simulator(redheadDuck);
    //        simulator(duckCall);
    //        simulator(rubberDuck);
    //        simulator(gooseDuck);
    //        System.out.println("The ducks quacked " + QuaclCounter.getQuacks() + " times");
    //
    //    }

    /**
     * 模拟鸭子(绿头鸭，红头鸭、鸭鸣器、橡皮鸭)
     */
    void simulator() {

        /**
         * 装饰模式来构造对象
         */
        Quackable mallardDuck = new QuaclCounter(new ImplMallardDuck());
        Quackable redheadDuck = new QuaclCounter(new ImplRedheadDuck());
        Quackable duckCall = new QuaclCounter(new DuckCall());
        Quackable rubberDuck = new QuaclCounter(new RubberDuck());
        /**
         * 适配器模式来构造对象
         */
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Decorator");

        simulator(mallardDuck);
        simulator(redheadDuck);
        simulator(duckCall);
        simulator(rubberDuck);
        simulator(gooseDuck);
        System.out.println("The ducks quacked " + QuaclCounter.getQuacks() + " times");

    }

    /**
     * 模拟鸭子(绿头鸭，红头鸭、鸭鸣器、橡皮鸭)
     */
    //    void simulator() {
    //
    //        Quackable mallardDuck = new ImplMallardDuck();
    //        Quackable redheadDuck = new ImplRedheadDuck();
    //        Quackable duckCall = new DuckCall();
    //        Quackable rubberDuck = new RubberDuck();
    //        System.out.println("\nDuck Simulator");
    //
    //        /**
    //         * 适配器模式来构造对象
    //         */
    //        Quackable gooseDuck = new GooseAdapter(new Goose());
    //
    //        System.out.println("\nDuck Simulator");
    //
    //        simulator(mallardDuck);
    //        simulator(redheadDuck);
    //        simulator(duckCall);
    //        simulator(rubberDuck);
    //        simulator(gooseDuck);
    //
    //    }

    /**
     * 模拟一种鸭子
     * @param duck
     */
    void simulator(Quackable duck) {
        duck.quack();
    }

}
