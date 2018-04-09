package hyf.internation.controllers;

import hyf.internation.beans.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/22.
 */
@Controller
public class User2Controller {

    @RequestMapping(value = "/user1/{formName}")
    public String loginForm(@PathVariable String formName,
                            String request_locale, Model model,
                            HttpServletRequest request, HttpServletResponse response){
        System.out.println(String.format("request_locale = %s",request_locale));
        if (request_locale!=null){
            if ("zh_CN".equals(request_locale)){
                Locale locale = new Locale("zh","CN");
                new CookieLocaleResolver().setLocale(request,response,locale);

            }else if ("en_US".equals(request_locale)){
                Locale locale = new Locale("en","US");
                new CookieLocaleResolver().setLocale(request,response,locale);
            }else{
                new CookieLocaleResolver().setLocale(request,response,LocaleContextHolder.getLocale());
            }
        }
        User user = new User();
        model.addAttribute("user",user);
        return formName;
    }

    @RequestMapping(value = "/user1/login",method = RequestMethod.POST)
    public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request){
        if (user.getLoginName()!=null &&
                user.getLoginName().equals("zxxss")&&
                user.getPassword()!=null &&
                user.getPassword().equals("521")){
            //
            RequestContext requestContext = new RequestContext(request);
            String userName = requestContext.getMessage("username");
            user.setUserName(userName);
            model.addAttribute("user",user);
            return "success";
        }
        return "loginForm";
    }
}
