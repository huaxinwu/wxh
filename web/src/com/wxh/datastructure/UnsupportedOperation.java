/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 不支持操作异常
 * @author wxh
 * @version $Id: UnsupportedOperation.java, v 0.1 2017年12月1日 下午1:42:37 wxh Exp $
 */
public class UnsupportedOperation extends RuntimeException {

    /** */
    private static final long serialVersionUID = -6636138516206486319L;

    public UnsupportedOperation(String err) {
        super(err);
    }

}
