/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 线程安全的计数器(影响性能，不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: SynchronizedFactorizer.java, v 0.1 2017年10月24日 上午11:39:31 wxh Exp $
 */
@ThreadSafe
public class SynchronizedFactorizer implements Servlet {
    @GuardedBy("this")
    private BigInteger   lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    /** 
     * 
     * @see javax.servlet.Servlet#destroy()
     */
    @Override
    public void destroy() {
    }

    /** 
     * @return
     * @see javax.servlet.Servlet#getServletConfig()
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /** 
     * @return
     * @see javax.servlet.Servlet#getServletInfo()
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /** 
     * @param config
     * @throws ServletException
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    /** 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    public synchronized void service(ServletRequest request, ServletResponse response)
                                                                                      throws ServletException,
                                                                                      IOException {

        BigInteger bigInteger = extractFromRequest(request);
        if (bigInteger.equals(lastNumber)) {
            encodeIntoResponse(response, lastFactors);
        } else {
            BigInteger[] factors = factor(bigInteger);
            lastNumber = bigInteger;
            lastFactors = factors;
            encodeIntoResponse(response, factors);
        }
    }

    /**
     *
     * @param response
     * @param factors
     */
    private void encodeIntoResponse(ServletResponse response, BigInteger[] factors) {
    }

    /**
     *
     * @param bigInteger
     * @return
     */
    private BigInteger[] factor(BigInteger bigInteger) {
        return null;
    }

    /**
     *
     * @param request
     * @return
     */
    private BigInteger extractFromRequest(ServletRequest request) {
        return null;
    }

}
