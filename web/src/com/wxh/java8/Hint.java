/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

import java.lang.annotation.Repeatable;

/**
 * 可重复注解@Repeatable
 * @author wxh
 * @version $Id: Hint.java, v 0.1 2018年2月6日 下午4:36:29 wxh Exp $
 */
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
