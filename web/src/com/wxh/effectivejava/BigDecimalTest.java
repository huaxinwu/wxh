/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.math.BigDecimal;

/**
 * 对应货币计算，不使用float和double ,使用bigdecimal
 * 商务计算、不介意原语类型带来的不便，使用bigdecimal
 * 如果数字范围不超过9位数，使用int,不超过18位数，使用long,超过18位数，必须使用bigdecimal
 * @author wxh
 * @version $Id: BigDecimalTest.java, v 0.1 2017年9月18日 上午11:13:05 wxh Exp $
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        // 1.使用double计算结果
        double funds = 1.00;
        int itemBought = 0;
        for (double price = .10; funds >= price; price += .10) {
            funds -= price;
            itemBought++;
        }
        System.out.println(itemBought + " item bought double");
        System.out.println("double change: $ " + funds);

        // 2. 使用BigDecimal计算结果
        /**
         * TEN_CENTS 十美分
         */
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemBoughtBig = 0;
        BigDecimal fundsBig = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; fundsBig.compareTo(price) >= 0; price = price
            .add(TEN_CENTS)) {
            fundsBig = fundsBig.subtract(price);
            itemBoughtBig++;
        }
        System.out.println(itemBoughtBig + " item bought bigdecimal");
        System.out.println("bigdecimal change: $ " + fundsBig);

        // 3.使用int计算结果
        int fundsInt = 100;
        int itemBoughtInt = 0;
        for (int price = 10; fundsInt > price; price += 10) {
            fundsInt -= price;
            itemBoughtInt++;
        }
        System.out.println(itemBoughtBig + " item bought int");
        System.out.println("int change: $ " + fundsBig);
    }

}
