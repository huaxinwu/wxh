/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.JFrame;

/**
 * 测试图片代理
 * @author wxh
 * @version $Id: ImageProxyTestDriver.java, v 0.1 2017年6月13日 下午2:35:25 wxh Exp $
 */
public class ImageProxyTestDriver {
    ImageComponent imageComponent;

    public static void main(String[] args) throws Exception {
        ImageProxyTestDriver testDriver = new ImageProxyTestDriver();
    }

    public ImageProxyTestDriver() throws Exception {
        URL initialURL = new URL(null);
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        JFrame frame = new JFrame();
        frame.getContentPane().add(imageComponent);
    }
}
