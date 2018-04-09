package chapter04.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 没有返回视图的Controller
 *
 * @author yafei.hou  on 2018/1/26
 */
public class HelloWorldCacheController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //点击后再次请求当前页面
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }
}
