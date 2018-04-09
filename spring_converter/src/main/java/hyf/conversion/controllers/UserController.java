package hyf.conversion.controllers;

import hyf.conversion.beans.User;
import hyf.conversion.utils.DateEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Locale;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/22.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user/{formName}")
    public String loginForm01(@PathVariable String formName,
                            String request_locale, Model model,
                            HttpServletRequest request){
        System.out.println(String.format("request_locale = %s",request_locale));
        if (request_locale!=null){
            if ("zh_CN".equals(request_locale)){
                Locale locale = new Locale("zh","CN");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);

            }else if ("en_US".equals(request_locale)){
                Locale locale = new Locale("en","US");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else{
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                        LocaleContextHolder.getLocale());
            }
        }
        User user = new User();
        model.addAttribute("user",user);
        return formName;
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request){
        if (user.getLoginName()!=null &&
                user.getLoginName().equals("zxx")&&
                user.getPassword()!=null &&
                user.getPassword().equals("521")){
            //
            RequestContext requestContext = new RequestContext(request);
            String userName = requestContext.getMessage("username");
            user.setUserName(userName);
            model.addAttribute("user",user);
            return "success";
        }
        return "error";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(Date.class,new DateEditor());
//    }

    @RequestMapping(value = "/{formName}")
    public String loginForm02(@PathVariable String formName){
        return formName;
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute User user,Model model){
        model.addAttribute("user",user);
        return "success";
    }
}
