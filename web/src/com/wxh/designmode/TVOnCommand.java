/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 电灯打开命令对象
 * @author wxh
 * @version $Id: LightCommand.java, v 0.1 2017年4月19日 下午3:21:17 wxh Exp $
 */
public class TVOnCommand implements Command {
    // 引入产商对象
    TV tv;

    /**
     * 
     */
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    /** 
     * 接收对象
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        // 打开电视
        tv.on();
    }

    /** 
     * 撤销
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
        tv.off();
    }

}
