package com.hyf.servletTest.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Context监听器
 *
 * @author yafei.hou  on 2018/2/26
 */
@WebListener
public class Applistener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext  sc = servletContextEvent.getServletContext();
        Map<String,String> students = new HashMap<>(8);
        students.put("hyf","shanghai");
        students.put("ll","xinjiang");
        students.put("xiaokun","pudong");
        students.put("qin","minhang");
        sc.setAttribute("student",students);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
