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
 * 因数分解servlet(无状态)
 * @author wxh
 * @version $Id: StatelessFactorizer.java, v 0.1 2017年10月24日 上午10:24:57 wxh Exp $
 */
@ThreadSafe
public class StatelessFactorizer implements Servlet {

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
