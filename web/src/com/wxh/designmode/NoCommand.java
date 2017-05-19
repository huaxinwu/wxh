/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 没有命令
 * @author wxh
 * @version $Id: NoCommand.java, v 0.1 2017年4月20日 下午4:38:31 wxh Exp $
 */
public class NoCommand implements Command {

    /** 
     * 
     * @see com.wxh.designmode.Command#execute()
     */
    @Override
    public void execute() {
    }

    /** 
     * 
     * @see com.wxh.designmode.Command#undo()
     */
    @Override
    public void undo() {
    }

}
