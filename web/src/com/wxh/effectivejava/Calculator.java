/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 *  计算器
 *  匿名类常见用法是创建一个过程对象，其次，在一个静态工厂方法内部，再次，在复杂的类型安全枚举中，
 *  用于公有静态final属性初始化
 * @author wxh
 * @version $Id: Calculator.java, v 0.1 2017年9月8日 上午11:39:04 wxh Exp $
 */
public class Calculator {

    public static abstract class Operation {
        /** */

        private final String name;

        /**
         * 
         * 计算方法
         * @param x
         * @param y
         * @return double
         */
        abstract double eval(double x, double y);

        /**
         * 匿名内部类
         * 相加
         */
        public static final Operation PLUS   = new Operation("+") {
                                                 @Override
                                                 double eval(double x, double y) {
                                                     return x + y;
                                                 }
                                             };
        /**
         * 相减
         */
        public static final Operation MINUS  = new Operation("-") {
                                                 @Override
                                                 double eval(double x, double y) {
                                                     return x - y;
                                                 }
                                             };
        /**
         * 相乘
         */
        public static final Operation TIMES  = new Operation("*") {
                                                 @Override
                                                 double eval(double x, double y) {
                                                     return x * y;
                                                 }
                                             };
        /**
         * 相除
         */
        public static final Operation DIVIDE = new Operation("/") {
                                                 @Override
                                                 double eval(double x, double y) {
                                                     return x / y;
                                                 }
                                             };

        Operation(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    /**
     * 计算方法
     * @param x
     * @param y
     * @param op
     * @return
     */
    public double calculate(double x, double y, Operation op) {
        return op.eval(x, y);
    }
}
