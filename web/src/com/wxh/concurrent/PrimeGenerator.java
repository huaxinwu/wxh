/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 用volatile来保存取消的状态
 * @author wxh
 * @version $Id: PrimeGenerator.java, v 0.1 2017年10月31日 下午2:43:18 wxh Exp $
 */
public class PrimeGenerator implements Runnable {
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    /**取消状态标志  */
    private volatile boolean       cancled;

    /** 
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

}
