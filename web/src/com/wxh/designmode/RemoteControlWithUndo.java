/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: RemoteControlWithUndo.java, v 0.1 2017年4月25日 下午2:54:13 wxh Exp $
 */
public class RemoteControlWithUndo {

    /** 多个开的开关  */
    Command[] onCommands;
    /** 多个关的开关  */
    Command[] offCommands;
    /** 前一个命令将会被设置在这里  */
    Command   undoCommand;

    /**
     * 构造器初始化
     */
    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        /**
         * 在设计模式中，很多时候都使用空对象，甚至有时候空对象也被当成一种设计模式。
         */
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            // 把所有开关都设置成没有执行命令
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        // 一开始并没有设置前一个命令
        undoCommand = noCommand;
    }

    /**
     * 
     * @param slot 插槽位置
     * @param onCommand 开的命令
     * @param offCommand 关的命令
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /**
     * 按下某个位置的插槽开按钮
     * @param slot
     */
    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    /**
     * 按下某个位置的插槽关按钮
     * @param slot
     */
    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    /**
     * 没有按下按钮--撤销
     */
    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    /** 
     * 重写toString方法
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n----------Remote Control with undo------------\n");
        for (int i = 0; i < offCommands.length; i++) {
            buffer.append("[slot " + i + "]" + onCommands[i].getClass().getName() + " "
                          + offCommands[i].getClass().getName() + "\n");
        }
        return buffer.toString();
    }
}
