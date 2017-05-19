package com.wxh.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 线程来实现
 *
 * @author wxh
 * @version $Id: HttpRunnable.java, v 0.1 2016年12月26日 上午11:14:41 wxh Exp $
 */
public class HttpRunnable implements Runnable {
    String path   = "";
    String params = "";

    public HttpRunnable(String path, String params) {
        this.path = path;
        this.params = params;

    }

    @Override
    public void run() {
        try {
            String result = post(path, params);
            System.out.println("result is :" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //发送post请求，参数ʽkey1=value1&key2=value2...
    public static String post(String path, String params) throws Exception {
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            URL url = new URL(path);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);

            //发送post请求参数
            out = new PrintWriter(httpConn.getOutputStream());
            out.println(params);
            out.flush();

            // 读取响应
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuffer content = new StringBuffer();
                String tempStr = "";
                in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while ((tempStr = in.readLine()) != null) {
                    content.append(tempStr);
                }
                return content.toString();
            } else {
                throw new Exception("请求出现了问题");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
            httpConn.disconnect();
        }
        return null;
    }

}
