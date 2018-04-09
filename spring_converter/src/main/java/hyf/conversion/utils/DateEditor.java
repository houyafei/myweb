package hyf.conversion.utils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/27.
 */
public class DateEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        try {
            Date date = simpleDateFormat.parse(text);
            setValue(date);
            System.out.println("使用此处转换！");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期转换错误！");
        }
    }
}
