package hyf.conversion.controllers;

import hyf.conversion.beans.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/22.
 */
@Controller
public class UserController {

    Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm02(@PathVariable String formName){
        return formName;
    }

    @RequestMapping(value = "/testForm")
    public String register(@ModelAttribute User user,Model model){
        model.addAttribute("user",user);
        logger.info(user);
        return "success";
    }
}
