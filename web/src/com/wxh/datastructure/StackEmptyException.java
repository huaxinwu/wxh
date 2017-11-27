/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 栈为空异常
 * @author wxh
 * @version $Id: StackEmptyException.java, v 0.1 2017年11月22日 下午4:22:53 wxh Exp $
 */
public class StackEmptyException extends RuntimeException {

    /** */
    private static final long serialVersionUID = 9026599395065324895L;

    /**
     * 
     */
    public StackEmptyException(String err) {
        super(err);
    }

}
