/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 大量命令
 * @author wxh
 * @version $Id: MacroCommand.java, v 0.1 2017年5月5日 下午4:14:11 wxh Exp $
 */
public class MacroCommand implements Command {
    Command[] commands;

    /**
     * 
     */
    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
        }
    }

}
