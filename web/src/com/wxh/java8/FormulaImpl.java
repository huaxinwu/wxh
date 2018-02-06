/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * 子类直接调用接口的默认方法(jdk1.8提供的)
 * @author wxh
 * @version $Id: FormulaImpl.java, v 0.1 2018年2月6日 下午2:20:36 wxh Exp $
 */
public class FormulaImpl {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                // 直接调用默认方法
                return sqrt(a * 100);
            }
        };

        System.out.println("calculate: " + formula.calculate(100));
        System.out.println("sqrt: " + formula.sqrt(16));

    }

}
