package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 图片链接过滤
 *
 * @author yafei.hou  on 2018/3/1
 */

@WebFilter(filterName = "imageFilter",urlPatterns = {"*.jpg","*.png","*.jpeg"})
public class ImageFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("begin to filter the image");
        String reference = httpServletRequest.getHeader("referer");
        System.out.println("hearder reference ="+reference);
        if (reference==null || "".equals(reference)){
            throw new ServletException("the resource not available");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
