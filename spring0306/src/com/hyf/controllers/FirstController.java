package com.hyf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 第一个controller
 *
 * @author yafei.hou  on 2018/3/5
 */
@Controller
public class FirstController {

    @RequestMapping("/hello")
    public String testHello(){
        return "test";
    }

}
