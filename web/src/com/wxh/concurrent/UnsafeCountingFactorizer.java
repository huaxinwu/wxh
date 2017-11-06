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
 * 不安全的计数器(不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: UnsafeCountingFactorizer.java, v 0.1 2017年10月24日 上午10:36:41 wxh Exp $
 */
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {
    private long count = 0;

    public long getCount() {
        return count;
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
     * @param arg0
     * @throws ServletException
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig arg0) throws ServletException {
    }

    /** 
     * @param arg0
     * @param arg1
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException,
                                                                         IOException {
        BigInteger bigInteger = extractFromRequest(request);
        BigInteger[] factors = factor(bigInteger);
        ++count;
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
