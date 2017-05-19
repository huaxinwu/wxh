/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 首选咖啡（星巴克咖啡名）
 * @author wxh
 * @version $Id: HouseBlend.java, v 0.1 2017年4月17日 上午11:36:02 wxh Exp $
 */
public class HouseBlend extends Beverage {
    /**
     * 
     */
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    /** 
     * @return
     * @see com.wxh.designmode.Beverage#cost()
     */
    @Override
    public double cost() {
        return .89;
    }

}
