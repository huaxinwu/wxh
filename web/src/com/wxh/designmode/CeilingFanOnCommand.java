/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: CeilingFanOnCommand.java, v 0.1 2017年4月25日 下午2:02:03 wxh Exp $
 */
public class CeilingFanOnCommand implements Command {

    CeilingFan ceilingFan;

    /**
     * 
     */
    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        ceilingFan.on();
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
    }

}
