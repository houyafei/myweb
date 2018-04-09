package hyf.conversion.controllers;

import hyf.conversion.beans.User;
import hyf.conversion.beans.UserValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/22.
 */
@Controller
public class UserController {

    Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator ;


    @RequestMapping(value = "/{formName}")
    public String loginForm02(@PathVariable String formName,Model model){
        User user = new User();
        model.addAttribute("user",user);
        return formName;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, Model model, Errors errors){
        model.addAttribute("user",user);
        logger.info(user);
        userValidator.validate(user,errors);
        if (errors.hasErrors()){
            return "loginForm";
        }
        return "success";
    }
}
