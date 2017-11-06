/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.concurrent.Callable;

/**
 * 加载文件任务
 * @author wxh
 * @version $Id: LoadFileTask.java, v 0.1 2017年11月3日 上午10:55:25 wxh Exp $
 */
public class LoadFileTask implements Callable {
    private String src;

    public LoadFileTask(String src) {
        this.src = src;
    }

    /** 
     * @return
     * @throws Exception
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Object call() throws Exception {
        return null;
    }

}
