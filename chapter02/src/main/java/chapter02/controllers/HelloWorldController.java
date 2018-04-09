package chapter02.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用springmvc
 *
 * @author yafei.hou  on 2018/1/25
 */
public class HelloWorldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象
        String url = "http://static1.gotokeep.com/course/public/buttocks_cultivating.mp4";
        mv.addObject("message", "Hello ,努力到无能为力,视频大小为 " + getVideoSize(url));
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("hello");
        return mv;
    }

    private String getVideoSize(String url) throws Exception {
        String[] sizeStr = {""};

        URL ul = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ul.openConnection();
        long size = conn.getContentLength() / 1024;
        sizeStr[0] = size > 1024 ? String.valueOf(size / 1024) + "MB" : String.valueOf(size) + "KB";
        System.out.println("视频资源大小为："+sizeStr[0]);

        conn.disconnect();
        return sizeStr[0];
    }
}
