import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异步执行
 *
 * @author yafei.hou  on 2018/3/5
 */
public class AsyncCompleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html><head><title>"+"Async</title></head>");
        printWriter.println("<body><div id='progress'></div>");
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(3000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread:"+Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    printWriter.println("<script>");
                    printWriter.println("document.getElementById('progress').innerHTML='"+
                            (i*10)+"% completed'");
                    printWriter.println("</script>");
                    printWriter.flush();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("-------------------------"+ i);
                }
                printWriter.println("<script>");
                printWriter.println("document.getElementById("+
                        "'progress').innerHTML='DONE'");
                asyncContext.complete();
            }
        });
        printWriter.println("</script>");
        printWriter.println("</body></html>");
    }
}
