/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 简单遥控器:一个按钮、一个插槽
 * @author wxh
 * @version $Id: SimpleRemoteControl.java, v 0.1 2017年4月19日 下午3:30:42 wxh Exp $
 */
public class SimpleRemoteControl {
    /** 插槽  */
    Command slot;

    /**
     * 
     */
    public SimpleRemoteControl() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 设置插槽的控制命令
     */
    public void setCommand(Command command) {
        slot = command;
    }

    /**
     * 按下按钮
     */
    public void buttonWasPressed() {
        slot.execute();
    }
}
