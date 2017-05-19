/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 *
 * @author wxh
 * @version $Id: SearchServlet.java, v 0.1 2016年12月6日 上午10:06:10 wxh Exp $
 */
public class SearchServlet extends HttpServlet {

    /** */
    private static final long serialVersionUID = 6381349640550879325L;
    static List<String>       datas            = new ArrayList<String>();
    /**
     * 初始化数据
     */
    static {

        //模拟数据

        datas.add("ajax");
        datas.add("ajax1");
        datas.add("ajax get");
        datas.add("ajax post");
        datas.add("bill");
        datas.add("biyss");
        datas.add("bobm");
        datas.add("chckk");
        datas.add("cetty");
    }

    /**
    	 * Constructor of the object.
    	 */
    public SearchServlet() {
        super();
    }

    /**
    	 * Destruction of the servlet. <br>
    	 */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
    	 * The doGet method of the servlet. <br>
    	 *
    	 * This method is called when a form has its tag value method equals to get.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                               throws ServletException,
                                                                               IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //接收参数
        String keyword = request.getParameter("keyword");
        //响应给前台数据
        List<String> result = getData(keyword);

        JSONArray jsonArray = JSONArray.fromObject(result);
        //转成json输出到输出流中
        response.getWriter().write(jsonArray.toString());

    }

    /**
     * 通过输入参数查询关联数据
     * @param keyword
     * @return
     */
    public List<String> getData(String keyword) {
        List<String> list = new ArrayList<String>();
        for (String data : datas) {
            if (data.contains(keyword)) {
                list.add(data);
            }
        }
        return list;
    }

    /**
    	 * The doPost method of the servlet. <br>
    	 *
    	 * This method is called when a form has its tag value method equals to post.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                                                                                throws ServletException,
                                                                                IOException {
        doGet(request, response);

    }

    /**
    	 * Initialization of the servlet. <br>
    	 *
    	 * @throws ServletException if an error occurs
    	 */
    public void init() throws ServletException {
        // Put your code here
    }

}
