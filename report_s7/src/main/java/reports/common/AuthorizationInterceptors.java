package reports.common;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yafei.hou
 *         Created by yafei.hou on 2017/12/25.
 */
public class AuthorizationInterceptors implements HandlerInterceptor {


    private static final String[] WHITE_LIST = {"/login", "/logout"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        boolean flag = false;
        String path = httpServletRequest.getServletPath();
        for (String whitePath : WHITE_LIST) {
            if (path.contains(whitePath)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            String token = (String) httpServletRequest.getSession().getAttribute("token");
            if (token.isEmpty()){
                httpServletRequest.getRequestDispatcher(WHITE_LIST[0]).forward(httpServletRequest,httpServletResponse);
            }else {
                flag=true;
            }
        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
