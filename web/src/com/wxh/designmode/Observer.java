/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 观察者
 * @author wxh
 * @version $Id: Observer.java, v 0.1 2017年3月28日 下午2:38:26 wxh Exp $
 */
public interface Observer {

    /**
     * 更新主题状态
     * @param temp
     * @param huhumidity
     * @param pressure
     */
    public void update(float temp, float humidity, float pressure);
}
