/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: GarageDoorDownCommand.java, v 0.1 2017年4月25日 下午2:10:03 wxh Exp $
 */
public class GarageDoorDownCommand implements Command {

    GarageDoor garageDoor;

    /**
     * 
     */
    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        garageDoor.down();
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
    }

}
