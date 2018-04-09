package chapter04.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 没有返回视图的Controller
 *
 * @author yafei.hou  on 2018/1/26
 */
public class HelloWorldWithoutReturnModelAndViewController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("该方式要设置response.setContentType(\"text/html\");</br>");
        printWriter.write("该方式要设置response.setCharacterEncoding(\"UTF-8\");</br>");
        printWriter.write("ok ");
        HttpSession session =request.getSession();
        printWriter.write(String.format("session = %s",session));
        return null;
    }
}
