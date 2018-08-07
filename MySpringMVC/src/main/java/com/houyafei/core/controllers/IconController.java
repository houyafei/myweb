package com.houyafei.core.controllers;

import com.houyafei.annotation.MyController;
import com.houyafei.annotation.MyRequestMapping;

/**
 * 图标显示的
 *
 * @author yafei.hou  on 2018/8/7
 */
@MyController
public class IconController {

    @MyRequestMapping("/favicon.ico")
    public String icon(){
        return "<html><body><a href=\"http://www.baidu.com\" />redirect to baidu </body></html>";
    }
}
