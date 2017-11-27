/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 队列为空异常
 * @author wxh
 * @version $Id: QueueEmptyException.java, v 0.1 2017年11月23日 上午10:06:44 wxh Exp $
 */
public class QueueEmptyException extends RuntimeException {

    /** */
    private static final long serialVersionUID = -582499004213433004L;

    /**
     * 
     */
    public QueueEmptyException(String err) {
        super(err);
    }
}
