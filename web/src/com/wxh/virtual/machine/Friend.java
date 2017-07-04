/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * 朋友
 * @author wxh
 * @version $Id: Friend.java, v 0.1 2017年7月3日 下午2:18:46 wxh Exp $
 */
public class Friend implements Doer {
    private Doer    next;
    private boolean direct;

    /**
     * 构造数据
     */
    public Friend(Doer next, boolean direct) {
        this.next = next;
        this.direct = direct;
    }

    /** 
     *  获取权限，做一些事情
     * @see com.wxh.virtual.machine.Doer#doYourThing()
     */
    @Override
    public void doYourThing() {
        if (direct) {
            next.doYourThing();
        } else {
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    next.doYourThing();
                    return null;
                }
            });
        }
    }

}
