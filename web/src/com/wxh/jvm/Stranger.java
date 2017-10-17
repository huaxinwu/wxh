/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * 陌生人
 * @author wxh
 * @version $Id: Stranger.java, v 0.1 2017年7月3日 下午2:29:50 wxh Exp $
 */
public class Stranger implements Doer {
    private Doer    next;
    private boolean direct;

    /**
     * 构造数据
     */
    public Stranger(Doer next, boolean direct) {
        this.next = next;
        this.direct = direct;
    }

    /** 
     * 
     * @see com.wxh.jvm.Doer#doYourThing()
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
