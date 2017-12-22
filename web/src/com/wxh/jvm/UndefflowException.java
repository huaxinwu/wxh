/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 向下溢出异常
 * @author wxh
 * @version $Id: UndefflowException.java, v 0.1 2017年12月21日 下午4:02:02 wxh Exp $
 */
public class UndefflowException extends Exception {

    /** */
    private static final long serialVersionUID = -2516158003262860367L;

    public UndefflowException(String err) {
        super(err);
    }
}
