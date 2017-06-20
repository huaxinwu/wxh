/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;


/**
 * 呱呱叫学家
 * @author wxh
 * @version $Id: Duackologist.java, v 0.1 2017年6月20日 上午10:25:13 wxh Exp $
 */
public class Quackologist implements ObserverNew {

    /** 
     * 正在呱呱叫的对象
     * @param duck
     * @see com.wxh.designmode.ObserverNew#update(com.wxh.designmode.QuackObservable)
     */
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }

}
