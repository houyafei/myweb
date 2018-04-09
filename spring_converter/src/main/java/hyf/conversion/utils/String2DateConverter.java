package hyf.conversion.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yafei.hou on 2017/11/27.
 */
public class String2DateConverter implements Converter<String,Date> {

    //日期格式yyyy-MM-dd

    private String datePattern;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String strDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("parse the String to Date failed");
        }
        return null;
    }
}
