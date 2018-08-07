package com.houyafei.core.controllers;

import com.houyafei.annotation.MyController;
import com.houyafei.annotation.MyRequestMapping;

/**
 * 测试自己的注解类
 *
 * @author yafei.hou  on 2018/8/6
 */
@MyController
@MyRequestMapping("/hello")
public class TestController {

    @MyRequestMapping("/hello")
    public String helloWorld(String name){
        String str = "welcome :"+name;
        System.out.println(str);
        return str;
    }



}
