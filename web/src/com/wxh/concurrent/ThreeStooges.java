/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Immutable;

/**
 * 三个臭皮匠(不可变)
 * @author wxh
 * @version $Id: ThreeStooges.java, v 0.1 2017年10月25日 上午10:40:36 wxh Exp $
 */
@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooges(String name) {
        return stooges.contains(name);
    }
}
