/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 对象终结方法
 * 垃圾收集器在释放对象之前执行终结方法
 * @author wxh
 * @version $Id: ObjectEnd.java, v 0.1 2017年12月18日 下午2:17:54 wxh Exp $
 */
public class ObjectEnd {

    /** 
     * 对象终结方法
     * @throws Throwable
     * @see java.lang.Object#finalize()
     */
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
