package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 下载计数过滤器
 *
 * @author yafei.hou  on 2018/3/2
 */

//@WebFilter(filterName = "downloadFile", urlPatterns = {"/*"})
public class DownloadFilter implements Filter {

    Properties downloadLog;
    File log;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("initial the filter");
        String path = filterConfig.getServletContext().getRealPath("/");
        log = new File(path, "downloadLog.txt");
        if (!log.exists()) {
            try {
                log.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(log));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String uri = httpServletRequest.getRequestURI();
        executorService.execute(() -> {
            String value = downloadLog.getProperty(uri);
            if (value == null) {
                downloadLog.setProperty(uri, "1");
            } else {
                int count = Integer.parseInt(value);
                count++;
                downloadLog.setProperty(uri, String.valueOf(count));
            }

            try {
                downloadLog.store(new FileWriter(log),"this is a 数据资源文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}
