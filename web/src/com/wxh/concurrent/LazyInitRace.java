/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 延迟初始化(多态就体现这点,不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: LazyInitRace.java, v 0.1 2017年10月24日 上午10:58:30 wxh Exp $
 */
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

}
