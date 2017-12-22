/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 向上溢出异常
 * @author wxh
 * @version $Id: OverflowException.java, v 0.1 2017年12月21日 下午4:00:57 wxh Exp $
 */
public class OverflowException extends Exception {

    /** */
    private static final long serialVersionUID = -3437321155864560079L;

    public OverflowException(String err) {
        super(err);
    }
}
