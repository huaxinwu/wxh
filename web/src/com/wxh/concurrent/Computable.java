/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 可比较的接口
 * @author wxh
 * @version $Id: Computable.java, v 0.1 2017年10月30日 下午2:16:46 wxh Exp $
 */
public interface Computable<K, V> {

    V compute(K arg) throws InterruptedException;;
}
