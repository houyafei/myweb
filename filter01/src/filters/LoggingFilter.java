package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志过滤器
 *
 * @author yafei.hou  on 2018/2/27
 */
@WebFilter(filterName = "logFilter", urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "logFileName", value = "log.txt"),
                @WebInitParam(name = "prefix", value = "URI: ")})
public class LoggingFilter implements Filter {

    private PrintWriter logging;

    private String prefix;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        prefix = filterConfig.getInitParameter("prefix");
        String logFileName = filterConfig.getInitParameter("logFileName");
        String appPath = filterConfig.getServletContext().getRealPath("/");
        System.out.println("logFileName = " + logFileName);

        try {
            File file = new File(appPath, logFileName);
            logging = new PrintWriter(file);
            System.out.println(String.format("file path = %s",file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("this is in doFilter method...............");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logging.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + " " +
                prefix + httpServletRequest.getRequestURI() + "\n");

        logging.flush();
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("destorying filter---------------");
        if (logging != null) {
            logging.close();
        }
    }
}
