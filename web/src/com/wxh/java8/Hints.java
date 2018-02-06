/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * 定义一个包装类Hints注解用来放置一组具体的Hint注解
 * @author wxh
 * @version $Id: Hints.java, v 0.1 2018年2月6日 下午4:35:09 wxh Exp $
 */
public @interface Hints {
    Hint[] value();
}
