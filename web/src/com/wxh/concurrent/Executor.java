/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 执行器
 * @author wxh
 * @version $Id: Executor.java, v 0.1 2017年10月31日 上午10:23:20 wxh Exp $
 */
public interface Executor {
    /**
     * 执行
     * @param command
     */
    void execute(Runnable command);

}
