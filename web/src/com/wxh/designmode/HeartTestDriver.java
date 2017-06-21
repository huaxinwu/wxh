/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: HeartTestDriver.java, v 0.1 2017年6月20日 下午3:55:24 wxh Exp $
 */
public class HeartTestDriver {

    public static void main(String[] args) {
        HeartModelInterface heartModel = new HeartModel();
        ControllerInterfacr controller = new HeartController(heartModel);
    }
}
