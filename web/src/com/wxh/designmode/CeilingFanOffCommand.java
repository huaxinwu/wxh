/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: CeilingFanOffCommand.java, v 0.1 2017年4月25日 下午2:05:25 wxh Exp $
 */
public class CeilingFanOffCommand implements Command {

    CeilingFan ceilingFan;
    int        prevSpeed;

    /**
     * 
     */
    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
        if (prevSpeed == ceilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == ceilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == ceilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == ceilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
