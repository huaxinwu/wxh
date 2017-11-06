/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 不安全线程缓存计数器(在没有足够原子性保证的情况下对其最近计算结果进行缓存，不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: UnsafeCachingFactorizer.java, v 0.1 2017年10月24日 上午11:18:41 wxh Exp $
 */
@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {

    private final AtomicReference<BigInteger>   lastNumber  = new AtomicReference<BigInteger>();

    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

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
        if (bigInteger.equals(lastNumber.get())) {
            encodeIntoResponse(response, lastFactors.get());
        } else {
            BigInteger[] factors = factor(bigInteger);
            lastNumber.set(bigInteger);
            lastFactors.set(factors);
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
