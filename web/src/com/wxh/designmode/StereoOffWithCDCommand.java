/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: StereoOffWithCDCommand.java, v 0.1 2017年4月25日 下午2:14:36 wxh Exp $
 */
public class StereoOffWithCDCommand implements Command {

    Stereo stereo;

    /**
     * 
     */
    public StereoOffWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        stereo.off();
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
    }
}
