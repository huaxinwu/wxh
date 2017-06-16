/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 实现调用处理程序接口
 * @author wxh
 * @version $Id: ownerInvocationhandler.java, v 0.1 2017年6月16日 下午3:45:55 wxh Exp $
 */
public class OwnerInvocationhandler implements InvocationHandler {
    PersonBean person;

    /**
     * 
     */
    public OwnerInvocationhandler(PersonBean person) {
        super();
        this.person = person;
    }

    /** 
     * @param proxy
     * @param method
     * @param args
     * @return Object
     * @throws Throwable
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
