/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 音响打开播放CD
 * @author wxh
 * @version $Id: StereoOnWithCDCommand.java, v 0.1 2017年4月20日 下午5:03:59 wxh Exp $
 */
public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    /**
     * 
     */
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
    }

}
