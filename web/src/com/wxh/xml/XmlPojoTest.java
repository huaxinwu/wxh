/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 读取xml数据
 * @author wxh
 * @version $Id: XmlPojoTest.java, v 0.1 2016年11月25日 下午3:36:13 wxh Exp $
 */
@SuppressWarnings("serial")
public class XmlPojoTest implements java.io.Serializable {
    public static void main(String[] args) {
        List<XmlPojo> list = new XmlPojoTest().parseXmlPojo();
        for (XmlPojo p : list) {
            System.out.println(p.getName());
        }
    }

    /**
     * 解析xml文件，读取数据封装到list里面
     * @return
     */
    @SuppressWarnings("unused")
    private List<XmlPojo> parseXmlPojo() {
        //定义接收数据的集合
        List<XmlPojo> xmlPojos = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //获取解析器
            DocumentBuilder builder = factory.newDocumentBuilder();
            //读文件读到输入流
            InputStream inputStream = XmlPojoTest.class.getClassLoader().getResourceAsStream(
                "com/wxh/xml/XmlPojo.xml");
            //获取dom对象
            Document document = builder.parse(inputStream);
            //获取所有item节点
            NodeList list = document.getElementsByTagName("item");
            xmlPojos = new ArrayList<XmlPojo>();
            XmlPojo xmlPojo = null;

            for (int i = 0; i < list.getLength(); i++) {
                xmlPojo = new XmlPojo();
                //将数据封装到xmlPojo对象中
                Element element = (Element) list.item(i);
                String id = element.getAttribute("id");
                xmlPojo.setId(id);

                NodeList childList = element.getChildNodes();
                for (int j = 0; j < childList.getLength(); j++) {
                    Node node = childList.item(j);
                    switch (node.getNodeName()) {
                        case "name":
                            String name = node.getTextContent();
                            xmlPojo.setName(name);
                            break;
                        case "size":
                            String size = node.getTextContent();
                            xmlPojo.setSize(size);
                            break;

                        default:
                            break;
                    }
                }
                xmlPojos.add(xmlPojo);
                //让GC回收
                xmlPojo = null;
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xmlPojos;
    }
}
