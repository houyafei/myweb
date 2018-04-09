package com.hyf.requests;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 每个请求的监听
 *
 * @author yafei.hou  on 2018/2/27
 */
@WebListener
public class PerfStatListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest sr = servletRequestEvent.getServletRequest();
        long start = (long) sr.getAttribute("start");
        long end = System.nanoTime();
        long time = end - start;
        HttpServletRequest httpServletRequest = (HttpServletRequest) sr;
        System.out.println(String.format("请求时间段：%d - %d, 请求时长：%d，请求链接： %s",start,end,time,httpServletRequest.getRequestURI()));
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest sr = servletRequestEvent.getServletRequest();
        sr.setAttribute("start", System.nanoTime());
    }
}
