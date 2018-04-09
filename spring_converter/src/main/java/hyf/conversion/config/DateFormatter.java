package hyf.conversion.config;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/27.
 */
public class DateFormatter implements Formatter<Date> {

    /**
     * 日期格式模板
     */
    private String datePattern ;

    /**
     * 日期格式对象
     */
    private SimpleDateFormat dateFormat ;


    public DateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.dateFormat = new SimpleDateFormat(this.datePattern);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return dateFormat.format(object);
    }
}
