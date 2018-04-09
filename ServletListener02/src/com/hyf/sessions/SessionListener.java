package com.hyf.sessions;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Session监听器，实现对象计数
 *
 * @author yafei.hou  on 2018/2/27
 */
@WebListener
public class SessionListener implements HttpSessionListener ,ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc=servletContextEvent.getServletContext();
        sc.setAttribute("userCount",new AtomicInteger());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(1);
        ServletContext servletContext = session.getServletContext();
        AtomicInteger atomicInteger = (AtomicInteger) servletContext.getAttribute("userCount");
        int userCount = atomicInteger.incrementAndGet();
        System.out.println("用户数增加："+userCount+",sessionId:"+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session= httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger atomicInteger = (AtomicInteger) servletContext.getAttribute("userCount");
        int userCount = atomicInteger.decrementAndGet();
        System.out.println("用户数为减少后："+userCount);
    }
}
