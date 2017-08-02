/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

/**
 * Java虚拟机生命周期:从某个入口开始，中间执行相应操作，最后从入口退出
 * @author wxh
 * @version $Id: Echo.java, v 0.1 2017年7月12日 下午2:54:49 wxh Exp $
 */
public class Echo {

    public static void main(String[] args) {
        int len = args.length;
        for (int i = 0; i < len; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}
