/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: CeilingFanHighCommand.java, v 0.1 2017年5月5日 下午3:12:51 wxh Exp $
 */
public class CeilingFanMediumCommand implements Command {
    CeilingFan ceilingFan;
    int        prevSpeed;

    /**
     * 
     */
    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
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
