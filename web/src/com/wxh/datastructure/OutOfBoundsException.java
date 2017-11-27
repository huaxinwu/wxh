/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 越界异常
 * @author wxh
 * @version $Id: OutOfBoundsException.java, v 0.1 2017年11月20日 下午3:09:00 wxh Exp $
 */
public class OutOfBoundsException extends RuntimeException {

    /** */
    private static final long serialVersionUID = -1997570381891246054L;

    public OutOfBoundsException(String err) {
        super(err);
    }

}
