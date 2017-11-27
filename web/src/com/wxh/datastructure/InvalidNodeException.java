/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 无效结点异常
 * @author wxh
 * @version $Id: InvalidNodeException.java, v 0.1 2017年11月21日 下午4:11:03 wxh Exp $
 */
public class InvalidNodeException extends RuntimeException {

    /** */
    private static final long serialVersionUID = -4867286138013938356L;

    public InvalidNodeException(String err) {
        super(err);
    }

}
