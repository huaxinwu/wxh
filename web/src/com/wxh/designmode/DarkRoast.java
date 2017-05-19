/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 焦炒咖啡--深焙咖啡 
 * @author wxh
 * @version $Id: DarkRoast.java, v 0.1 2017年4月17日 下午1:53:31 wxh Exp $
 */
public class DarkRoast extends Beverage {
    /**
     * 
     */
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    /** 
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return .99;
    }

}
