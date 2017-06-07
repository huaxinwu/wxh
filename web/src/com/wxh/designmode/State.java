/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 所有状态顶层接口
 * @author wxh
 * @version $Id: State.java, v 0.1 2017年6月6日 下午3:41:22 wxh Exp $
 */
public interface State {

    /**
     * 投币
     */
    public void insertQuarter();

    /**
     * 退币
     */
    public void ejectQuarter();

    /**
     * 转动曲柄
     */
    public void turnCrank();

    /**
     * 分配糖果
     */
    public void dispense();
}
