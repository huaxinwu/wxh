/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 类的多态：在运行时候，确定使用哪种形态运行。
 * @author wxh
 * @version $Id: Computer.java, v 0.1 2017年11月16日 下午2:55:34 wxh Exp $
 */
public class Computer {
    public void run() {
        System.out.println("我是一台计算机");
    }

    public static void main(String[] args) {
        Computer computer = new Scanner();
        /**
         * 计算机转变为扫描仪
         * 输出结果：我是一台扫描仪
         */
        computer.run();
        computer = new Printer();
        /**
         * 计算机转变为打印机
         * 输出结果：我是一台打印机
         */
        computer.run();
    }

}

class Scanner extends Computer {
    @Override
    public void run() {
        System.out.println("我是一台扫描仪");
    }
}

class Printer extends Computer {
    @Override
    public void run() {
        System.out.println("我是一台打印机");
    }
}
