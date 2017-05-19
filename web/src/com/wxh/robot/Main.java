package com.wxh.robot;

public class Main {
    private static String url    = "http://www.tuling123.com/openapi/api";
    private static String key    = "2e7e930825c74e13944972bf3f282e4e";
    private static String userid = "7788";
    private static String info   = "我是你大爷";

    private static String param  = "key=" + key + "&info=" + info + "&userid=" + userid;

    public static void main(String[] args) {

        HttpRunnable runnable = new HttpRunnable(url, param);
        Thread thread = new Thread(runnable);
        thread.start();

    }

}
