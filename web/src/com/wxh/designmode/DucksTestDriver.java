/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Arrays;

/**
 *
 * @author wxh
 * @version $Id: DucksTestDriver.java, v 0.1 2017年5月27日 下午2:51:56 wxh Exp $
 */
public class DucksTestDriver {

    public static void main(String[] args) {
        Ducks[] ducks = { new Ducks("Dafiy", 8), new Ducks("Dewey", 2), new Ducks("Howard", 7),
                new Ducks("Louie", 2), new Ducks("Dorald", 10), new Ducks("Huey", 2) };
        System.out.println("before sorting... ");
        display(ducks);
        Arrays.sort(ducks);
        System.out.println("\nafter sorting... ");
        display(ducks);
    }

    /**
     * 显示数组中的每个元素
     * @param ducks
     */
    public static void display(Ducks[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            System.out.println(ducks[i]);
        }
    }
}
