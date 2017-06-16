/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.awt.Component;

import javax.swing.Icon;

/**
 * 图片组件
 * @author wxh
 * @version $Id: ImageComponent.java, v 0.1 2017年6月14日 上午10:03:07 wxh Exp $
 */
public class ImageComponent extends Component {
    Icon icon;

    /**
     * 
     */
    public ImageComponent(Icon icon) {
        this.icon = icon;
    }

}
