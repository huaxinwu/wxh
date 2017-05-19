/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.xml;

/**
 * xml对象封装读取xml传输、存储数据
 * @author wxh
 * @version $Id: XmlPojo.java, v 0.1 2016年11月25日 下午3:30:12 wxh Exp $
 */
@SuppressWarnings("serial")
public class XmlPojo implements java.io.Serializable {
    private String id;
    private String name;
    private String size;

    /**
     * 默认构造器
     */
    public XmlPojo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @param name
     * @param size
     */
    public XmlPojo(String id, String name, String size) {
        super();
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
