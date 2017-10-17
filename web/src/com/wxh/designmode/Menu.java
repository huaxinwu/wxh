/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Iterator;

/** 
 * 菜单
 * @author wxh
 * @version $Id: Menu.java, v 0.1 2017年6月1日 下午3:35:30 wxh Exp $
 */
public interface Menu {

    /**
     * 创建一个迭代器
     * @return
     */
    public Iterator createIteratorNative();
}
