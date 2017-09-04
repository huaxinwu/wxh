/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * freemarker用途：主要用来生成一些模板文件，比如tree树，word等等，与页面交互一般还是不要使用为好
 * 在所有采用网页静态化手段的网站中，FreeMarker使用的比例大大的超过了其他的一些技术。
 * HTML静态化也是某些缓存策略使用的手段，对于系统中频繁使用数据库查询但是内容更新很小的应用，
 * 可以使用FreeMarker将HTML静态化。比如一些网站的公用设置信息，这些信息基本都是可以通过后台来管理并存储在数据库中，
 * 这些信息其实会大量的被前台程序调用，每一次调用都会去查询一次数据库，但是这些信息的更新频率又会很小，
 * 因此也可以考虑将这部分内容进行后台更新的时候进行静态化，
 * 这样就避免了大量的数据库访问请求，从而也就提高了网站的性能。
 * 
 * 
 * 与JSP相比，FreeMarker的一个优点在于不能轻易突破模板语言开始编写Java代码，
 * 因此降低了领域逻辑漏进视图层的危险几率。但缺点是需要一点附加配置来将其平稳地集成到应用程序中，
 * 一些IDE（集成开发环境）可能并不完全支持它，当然还有开发者或设计者也许需要学习一门陌生的模板语言。
 * 相关的JAR文件将要添加到WEB-INF/lib（在需要的时候，它们包含在Spring中。
 * @author wxh
 * @version $Id: FreemarkerTest.java, v 0.1 2017年9月4日 上午11:15:59 wxh Exp $
 */
public class FreemarkerTest extends HttpServlet {

    /** */
    private static final long serialVersionUID = -1999446871611506118L;

    public static void main(String[] args) throws Exception {
        // 创建freemarker配置实例
        Configuration config = new Configuration();
        // 指定FreeMarker模板文件的位置 
        config.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")
                                                       + "/WebRoot/WEB-INF/templates"));

        // 创建数据模型
        Map<String, Object> root = new HashMap<String, Object>();
        // 字符串
        root.put("message", "hello world");
        root.put("name", "freemarker");
        root.put("username", "小明");
        // javabean对象
        User user = new User("小红", null);
        root.put("user", user);
        User user2 = new User("小兵", new Address("中国", "重庆"));
        root.put("user2", user2);

        // List
        List list = new ArrayList();
        list.add(new Address("中国", "北京"));
        list.add(new Address("中国", "上海"));
        list.add(new Address("美国", "纽约"));
        root.put("list", list);

        // 普通标量
        root.put("num0", 18);
        root.put("b2", true);
        root.put("date1", Calendar.getInstance().getTime());
        root.put("random", new Random().nextInt(100));
        root.put("htm2", "<b>粗体</b>");

        // 加载模板文件
        Template template = config.getTemplate("test.ftl");
        // 合并数据模型和模板，并将结果输出到out中  
        Writer out = new OutputStreamWriter(System.out);
        // 往模板里写数据  
        template.process(root, out);
        // 刷新缓存
        out.flush();

    }
}
