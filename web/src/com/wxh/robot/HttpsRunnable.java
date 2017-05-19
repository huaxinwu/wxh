package com.wxh.robot;

public class HttpsRunnable implements Runnable {
    static String path   = "";
    static String params = "";

    public HttpsRunnable(String path, String params) {
        HttpsRunnable.path = path;
        HttpsRunnable.params = params;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}
