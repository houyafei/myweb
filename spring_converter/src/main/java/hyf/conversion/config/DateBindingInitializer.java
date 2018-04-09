package hyf.conversion.config;

import hyf.conversion.utils.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/27.
 */
public class DateBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        //自定义编辑器
        webDataBinder.registerCustomEditor(Date.class,new DateEditor());
    }
}
