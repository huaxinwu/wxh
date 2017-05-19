/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.lang.StringUtils;

/**
 * 网络爬虫
 * @author wxh
 * @version $Id: Spider.java, v 0.1 2016年12月7日 下午2:42:49 wxh Exp $
 */
public class Spider {

    /**
     *
     * @param path 目标网页的链接
     * @return 返回结果
     * @throws Exception 抛出异常
     */
    public static boolean downloadPage(String path) throws Exception {
        HttpClient httpClient = new HttpClient();
        //定义输入、输出流
        InputStream inStream = null;
        OutputStream outStream = null;
        //获取get方法
        GetMethod method = new GetMethod(path);
        //执行状态
        int statusCode = httpClient.executeMethod(method);
        // 针对状态码进行处理
        // 简单起见，只处理返回值为 200 的状态码
        if (statusCode == HttpStatus.SC_OK) {
            inStream = method.getResponseBodyAsStream();
            String fileName = path.substring(path.lastIndexOf("/") + 1) + ".html";
            outStream = new FileOutputStream(fileName);
            int tempByte = -1;
            while ((tempByte = inStream.read()) > 0) {
                outStream.write(tempByte);
            }
            // 关闭输入流
            if (inStream != null) {
                inStream.close();
            }
            // 关闭输出流
            if (outStream != null) {
                outStream.close();
            }
            return true;
        }
        return false;
    }

    /**
     * 抓取各个网站登录页面信息
     * @throws HttpException
     * @throws IOException
     */
    public static void testLogin() throws HttpException, IOException {
        HttpClient httpClient = new HttpClient();
        String url = "https://reg.163.com/logins.jsp";
        //获取post方法
        PostMethod postMethod = new PostMethod(url);
        //伪造数据
        postMethod.addParameter("username", "xxxxxxx@126.com");
        postMethod.addParameter("password", "xxxxxx");
        //执行
        httpClient.executeMethod(postMethod);
        String response = postMethod.getResponseBodyAsString();
        System.out.println("爬虫爬取内容：" + response);

    }

    /**
     * 模拟上传URL文件
     * @param String
     * @return
     * @throws IOException 
     * @throws HttpException 
     */
    public static String doUploadFile(String postUrl) throws HttpException, IOException {
        if (StringUtils.isEmpty(postUrl)) {
            return null;
        }
        String response = "";
        PostMethod method = new PostMethod(postUrl);
        try {
            HttpClient httpClient = new HttpClient();
            //设置连接时间
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            int statusCode = httpClient.executeMethod(method);
            //响应成功才处理
            if (statusCode == HttpStatus.SC_OK) {
                InputStream inputStream = method.getResponseBodyAsStream();
                BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer buffer = new StringBuffer();
                String string = "";
                while ((string = buffReader.readLine()) != null) {
                    buffer.append(string);
                }
                response = buffer.toString();
            } else {
                response = "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return response;
    }

    /**
     * 上传文件到指定路径s
     * @param file
     * @param url
     * @return
     */
    public static String doUploadFile(File file, String url) {
        String response = "";
        if (!file.exists()) {
            return "flie not exists";
        }
        PostMethod method = new PostMethod(url);
        try {
            // FilePart：用来上传文件的类,file即要上传的文件
            FilePart fPart = new FilePart("file", file);
            Part[] parts = { fPart };
            // 对于MIME类型的请求，httpclient建议全用MultipartRequestEntity进行包装
            MultipartRequestEntity mpre = new MultipartRequestEntity(parts, method.getParams());
            method.setRequestEntity(mpre);

            HttpClient httpClient = new HttpClient();
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            int statusCode = httpClient.executeMethod(method);
            if (statusCode == HttpStatus.SC_OK) {
                InputStream inputStream = method.getResponseBodyAsStream();
                //装饰模式
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer buffer = new StringBuffer();
                String string = "";
                while ((string = reader.readLine()) != null) {
                    buffer.append(string);
                }
                response = buffer.toString();
            } else {
                response = "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return response;
    }

    /**
     * 测试
     * @param args
     * @throws HttpException
     * @throws IOException
     */
    public static void main(String[] args) throws HttpException, IOException {
        testLogin();
    }

}
