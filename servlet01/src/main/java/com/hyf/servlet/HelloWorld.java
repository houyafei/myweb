package com.hyf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一个简单的servlet小程序
 *
 * @author yafei.hou  on 2018/1/18
 */
public class HelloWorld extends HttpServlet {

    private String message;

    private int count = 0;

    @Override
    public void init() throws ServletException {
        System.out.println("this servlet has been init");
        message = "Hello World";
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        count += 1;
        System.out.println(String.format("this service has been executed %d times", count));
        out.println("<br>执行次数：" + count + "<br/>");
    }

    @Override
    public void destroy() {
        System.out.println("this servlet has been destroy");
    }

}
