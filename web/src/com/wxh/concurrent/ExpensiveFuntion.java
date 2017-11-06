/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.math.BigInteger;

/**
 * 高效函数
 * @author wxh
 * @version $Id: ExpensiveFuntion.java, v 0.1 2017年10月30日 下午2:18:42 wxh Exp $
 */
public class ExpensiveFuntion implements Computable<String, BigInteger> {

    /** 
     * @param arg
     * @return
     * @throws InterruptedException
     * @see com.wxh.concurrent.Computable#compute(java.lang.Object)
     */
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }

}
