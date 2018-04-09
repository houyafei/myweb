package servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 可以实现异步执行的servlet
 *
 * @author yafei.hou  on 2018/3/2
 */
//@WebServlet(value = "/a1", asyncSupported = true)
public class AsyncDispatchServlet extends HttpServlet {

    private static final long serialVersionUID = 202L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(5000);
        asyncContext.start(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            req.setAttribute("asyncThreadName", Thread.currentThread().getName());
            asyncContext.dispatch("/index2.jsp");
        });
    }
}
