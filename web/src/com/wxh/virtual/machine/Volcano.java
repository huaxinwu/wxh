/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

/**
 * 测试描述某个实现在Volcano中main方法字节码第一条指令
 * @author wxh
 * @version $Id: Volcano.java, v 0.1 2017年7月14日 上午11:09:01 wxh Exp $
 */
public class Volcano {
    public static void main(String[] args) {
        Lava lava = new Lava();
        lava.flow();
    }

}
