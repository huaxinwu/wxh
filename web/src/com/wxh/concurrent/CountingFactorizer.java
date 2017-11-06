/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 线程安全的计数器(Java加锁机制java.util.concurrent.atomic包含的原子变量)
 * @author wxh
 * @version $Id: CountingFactorizer.java, v 0.1 2017年10月24日 上午11:08:48 wxh Exp $
 */
@ThreadSafe
public class CountingFactorizer implements Servlet {

    /** 原子类  */
    private final AtomicLong count = new AtomicLong();

    public long getCount() {
        return count.get();
    }

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
    public void service(ServletRequest request, ServletResponse response) throws ServletException,
                                                                         IOException {
        BigInteger bigInteger = extractFromRequest(request);
        BigInteger[] factors = factor(bigInteger);
        count.incrementAndGet();
        encodeIntoResponse(response, factors);
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
