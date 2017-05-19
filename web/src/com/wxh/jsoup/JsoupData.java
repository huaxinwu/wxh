/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * jsoup抓取网页数据
 * jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。
 * 它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据
 * jsoup的主要功能如下：
 * 1. 从一个URL，文件或字符串中解析HTML；
 * 2. 使用DOM或CSS选择器来查找、取出数据；
 * 3. 可操作HTML元素、属性、文本；
 * jsoup是基于MIT协议发布的，可放心使用于商业项目。
 * @author wxh
 * @version $Id: JsoupData.java, v 0.1 2016年12月13日 上午11:40:49 wxh Exp $
 */
public class JsoupData {

    /**
     * 根据URL和编码获取网站信息
     * @param url
     * @param encoding
     * @return
     */
    public static String getHtmlResourceByUrl(String url, String encoding) {
        //大量数据操作，不同线程场景下
        StringBuffer buffer = new StringBuffer();
        URL urlObj = null;
        URLConnection uConnection = null;

        //字节流抓变字符流桥梁
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            //建立网络连接
            urlObj = new URL(url);
            //打开网络连接
            uConnection = urlObj.openConnection();

            //将数据写入缓冲流
            isr = new InputStreamReader(uConnection.getInputStream(), encoding);
            reader = new BufferedReader(isr);
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                //将读取的内容写入到缓存字符串中
                buffer.append(temp + "\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("没有联网，请检查网络");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("打开网络连接失败，请稍后重试");
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    /**
     * 根据URL和编码获取职位相关信息
     * @param url
     * @param encoding
     * @return
     */
    public static List<Map<String, String>> getJobInfo(String url, String encoding) {
        //1.根据URL和编码获取网站HTML代码
        String html = getHtmlResourceByUrl(url, encoding);
        //2.解析HTML源代码(以下对象都是针对jsoup包下的)
        Document document = Jsoup.parse(html);
        // 获取外层的div id="newlist_list_content_table"
        Element element = document.getElementById("newlist_list_content_table");
        // 获取工资结果集的列表 class="newlist"
        Elements elements = document.getElementsByClass("newlist");
        //将获取的数据封装到list中
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (Element ele : elements) {
            Map<String, String> map = new HashMap<String, String>();
            //获取超链接地址
            String link = ele.getElementsByTag("a").attr("href");
            System.out.println("-----------" + link);
            //公司名称
            String company = ele.getElementsByClass("gsmc").text();
            //职位名称
            String jobName = ele.getElementsByClass("zwmc").text();
            //工资
            String salary = ele.getElementsByClass("zwyx").text();
            //工作地点
            String address = ele.getElementsByClass("gzdd").text();
            //职位发布时间
            String publishTime = ele.getElementsByClass("gxsj").text();

            map.put("company", company);
            map.put("jobName", jobName);
            map.put("salary", salary);
            map.put("address", address);
            map.put("publishTime", publishTime);
            list.add(map);
        }
        return list;
    }

    /**
     * 解析a标签连接中信息
     * @param url
     * @param encoding
     * @return
     */
    public static List<Map<String, String>> getLinkInfo(String url, String encoding) {
        //1.根据URL和编码获取网站HTML代码
        String html = getHtmlResourceByUrl(url, encoding);
        //2.解析HTML源代码(以下对象都是针对jsoup包下的)
        Document document = Jsoup.parse(html);
        // 获取工资结果集的列表 class="tab-inner-cont"
        Elements elements = document.select("div.tab-inner-cont > p");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (Element ele : elements) {
            Map<String, String> map = new HashMap<String, String>();
            //获取a连接
            String link = ele.getElementsByTag("a").attr("href");
            //获取描述内容
            String content = ele.getElementsByTag("p").text();
            map.put("content", content);
            list.add(map);
        }

        return list;
    }

    /**
     * 测试入口
     * @param args
     */
    public static void main(String[] args) {
        String url = "http://www.51job.com/";
        String encoding = "gb2312";

        String html = getHtmlResourceByUrl(url, encoding);
        System.out.println(html);
    }
}
