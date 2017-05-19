/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 电灯关
 * @author wxh
 * @version $Id: LightOffCommand.java, v 0.1 2017年4月20日 下午4:57:43 wxh Exp $
 */
public class LightOffCommand implements Command {
    Light light;

    /**
     * 
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        light.off();
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
        light.on();
    }

}
