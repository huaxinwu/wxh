/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.Serializable;

/**
 * 一个名字，包含两个字符串(姓和名)、和一个字符(代表中间名的大写字母)
 * @author wxh
 * @version $Id: Name.java, v 0.1 2017年9月21日 下午3:13:32 wxh Exp $
 */
public class Name implements Serializable {

    /** */
    private static final long serialVersionUID = -816884043577645939L;
    private String            lastName;
    private String            firstName;
    private char              middleInitial;

}
