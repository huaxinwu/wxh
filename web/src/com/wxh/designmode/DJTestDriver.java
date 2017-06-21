/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * MVC整合，测试
 * @author wxh
 * @version $Id: DJTestDriver.java, v 0.1 2017年6月20日 下午3:41:13 wxh Exp $
 */
public class DJTestDriver {

    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        @SuppressWarnings("unused")
        ControllerInterfacr controller = new BeatController(model);
    }
}
