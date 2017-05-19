/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 电灯打开命令对象
 * @author wxh
 * @version $Id: LightCommand.java, v 0.1 2017年4月19日 下午3:21:17 wxh Exp $
 */
public class StereoOffCommand implements Command {
    // 引入产商对象
    Stereo stereo;

    /**
     * 
     */
    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /** 
     * 接收对象
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        // 打开电灯
        stereo.off();
    }

    /** 
     * 撤销
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
        stereo.on();
    }

}
