/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式七：命令模式(将请求封装成对象，以便使用不同请求，队列或者日志来参数化其他对象，也支持可撤销的操作)
 * 餐厅订餐应用：客户点餐，招待员拿到订单，送到窗口，厨师根据订单准备餐点。
 * @author wxh
 * @version $Id: Command.java, v 0.1 2017年4月19日 下午3:17:44 wxh Exp $
 */
public interface Command {
    /**
     * 命令对象执行方法
     */
    public void execute();

    /**
     * 命令对象撤销方法
     */
    public void undo();
}
