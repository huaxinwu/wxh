/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 自定义标签 步骤：
 * 一、编写标签处理器（java文件）
 * 二、在标签库描述符文件中描述该标签 (TLD文件)
 * 三、在jsp文件中引用该标签
 * 应用场景：
 * 1.创建自定义标签如Hello标签
 * 2.访问标签体<ex:Hello>This is message body</ex:Hello>
 * 3.设置自定义属性 ：设置各种属性，要接收属性，值，自定义标签类必须实现setter方法
 * @author wxh
 * @version $Id: HelloTag.java, v 0.1 2016年12月7日 上午10:08:43 wxh Exp $
 */
public class HelloTag extends SimpleTagSupport {
    //自定义属性
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    /** 
     * 重写doTag方法
     * @throws JspException
     * @throws IOException
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        //jsp自定义标签使用
        //        JspWriter out = getJspContext().getOut();
        //        out.println("hello custorm tag");

        //访问标签内容--标签体
        //        StringWriter sWriter = new StringWriter();
        //        getJspBody().invoke(sWriter);
        //        getJspContext().getOut().println(sWriter.toString());

        //自定义属性
        StringWriter swWriter = new StringWriter();
        if (message != null) {
            /* 使用属性中的消息 */
            getJspContext().getOut().println(message);
        } else {
            /* 使用标签体的消息 */
            getJspBody().invoke(swWriter);
            getJspContext().getOut().println(swWriter.toString());
        }
    }
}
