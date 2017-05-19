/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 车库门开启
 * @author wxh
 * @version $Id: GarageDoorOpenCommand.java, v 0.1 2017年4月20日 上午10:27:51 wxh Exp $
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    /**
     * 
     */
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        garageDoor.up();
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
    }

}
